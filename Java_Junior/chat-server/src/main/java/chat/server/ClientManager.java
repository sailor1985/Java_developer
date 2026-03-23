package chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {
    // Список всех подключенных клиентов для рассылки сообщений
    public static ArrayList<ClientManager> clientManagers = new ArrayList<>();

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Первое сообщение от клиента — это его имя (как мы писали в коде клиента)
            this.clientUsername = bufferedReader.readLine();
            if (this.clientUsername == null) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                return; // Выходим из конструктора, не добавляя в список
            }
            clientManagers.add(this);
            System.out.println(clientUsername + " подключился к чату");
            broadcastMessage("SERVER: " + clientUsername + " вошел в чат!");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                // Читаем сообщение от клиента
                messageFromClient = bufferedReader.readLine();
                if (messageFromClient == null) {
                    throw new IOException();
                }
                // Рассылаем всем остальным
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    // Метод для отправки сообщения всем клиентам, кроме отправителя
    public void broadcastMessage(String messageToSend) {
        for (ClientManager clientManager : clientManagers) {
            try {
                if (clientManager.clientUsername != null && !clientManager.clientUsername.equals(clientUsername)) {
                    clientManager.bufferedWriter.write(messageToSend);
                    clientManager.bufferedWriter.newLine();
                    clientManager.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    // Удаление клиента из списка и закрытие ресурсов
    public void removeClientHandler() {
        clientManagers.remove(this);
        System.out.println(clientUsername + " покинул чат");
        broadcastMessage("SERVER: " + clientUsername + " покинул чат.");
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
        try {
            if (bufferedReader != null) bufferedReader.close();
            if (bufferedWriter != null) bufferedWriter.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

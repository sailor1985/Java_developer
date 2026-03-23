package chat.server;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@AllArgsConstructor
public class Server {
    private final ServerSocket serverSocket;

    public void runServer() {
        try {
            System.out.println("Сервер запущен. Ожидание клиентов...");
            while (!serverSocket.isClosed()) {
                // Ожидаем новое подключение
                Socket socket = serverSocket.accept();
                System.out.println("Подключился новый клиент!");

                // Создаем отдельный объект для работы с этим клиентом
                ClientManager clientManager = new ClientManager(socket);

                // Запускаем обработчик в отдельном потоке
                Thread thread = new Thread(clientManager);
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
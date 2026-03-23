package chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Programm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите своё имя: ");
        String name = scanner.nextLine();

        try {
            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name);

            System.out.println("Remote IP: " + socket.getInetAddress().getHostAddress());
            System.out.println("LocalPort: " + socket.getLocalPort());

            // Важно: сначала запускаем поток прослушивания
            client.listenForMessage();
            // Затем запускаем метод отправки (он заблокирует поток main своим циклом)
            client.sendMessage();

        } catch (IOException e) {
            System.out.println("Не удалось подключиться к серверу.");
            e.printStackTrace();
        }
    }
}

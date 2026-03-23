package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Programm {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1400)) {
            Server server = new Server(serverSocket);
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

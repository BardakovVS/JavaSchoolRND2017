package homeWork.homeWork15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bardakov.vs on 13.10.2017.
 */
public class ChatServer {
    private static final int PORT = 5000;
    private static final Map<Socket, String> sockets = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен. Жду соединения...");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Подключение: " + socket.getInetAddress() + ":" + socket.getPort());
                sockets.put(socket, "");
                new ClientHandler(socket, sockets).start();
            }
        } catch (IOException e) {
            System.err.println("IOException" + e);
        }
        serverSocket.close();
    }
}


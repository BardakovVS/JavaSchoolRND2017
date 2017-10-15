package homeWork.homeWork15;

import java.io.*;
import java.net.Socket;

/**
 * Created by bardakov.vs on 13.10.2017.
 */
public class ChatClient {
    private static final int PORT = 5000;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            //DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            Thread inMessagesReader = new Thread(() -> {
                try {
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String readLine;
                    while (!Thread.currentThread().isInterrupted() && ((readLine = in.readUTF()) != null)) {
                        System.out.println(readLine);
                    }
                } catch (IOException e) {
                    System.out.println("Соединение закрыто!");
                }
            });
            inMessagesReader.start();
            while (!line.trim().toLowerCase().equals("exit")) {
                line = keyboard.readLine();
                out.writeUTF(line);
                out.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
















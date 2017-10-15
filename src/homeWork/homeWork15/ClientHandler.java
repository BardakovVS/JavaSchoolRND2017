package homeWork.homeWork15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

/**
 * Created by bardakov.vs on 13.10.2017.
 */
public class ClientHandler extends Thread {
    private Socket socket;
    private Map<Socket, String> sockets;

    public ClientHandler(Socket socket, Map<Socket, String> sockets) {
        this.socket = socket;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        String line = "Welcome to this chat!" + "\n" + "Введите свое имя:";
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(line);
            out.flush();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            boolean isName = false;
            while (!isName) {
                line = in.readUTF();
                if (line.trim().equals("")) {
                    out.writeUTF("system >> Имя не может быть пустым!" + "\n" + "Введите свое имя:");
                    out.flush();
                } else if (nameInMap(line, sockets)) {
                    out.writeUTF("system >> В чате уже есть участник с именем " + line + "! Введите другое имя. " + "\n" + "Введите свое имя:");
                    out.flush();
                } else {
                    out.writeUTF("Welcome to this chat, " + line + "!" + "\n" +
                            "Для отправки личного сообщения введите \"Имя\"=>\"сообщение\"," +
                            "иначе сообщение увидят все.");
                    out.flush();
                    for (Socket tempSocket : sockets.keySet()) {
                        if (!sockets.get(tempSocket).equals("")) {
                            DataOutputStream outAll = new DataOutputStream(tempSocket.getOutputStream());
                            outAll.writeUTF("system >> К чату присоединился " + line + "!");
                            outAll.flush();
                        }
                    }
                    System.out.println("system >> К чату присоединился " + line + "!");
                    sockets.put(socket, line);
                    isName = true;
                }
            }
            int pos;
            while (!Thread.currentThread().isInterrupted()) {
                line = in.readUTF();
                if (line.toLowerCase().trim().equals("exit")) {
                    System.out.println("Соединение c " + sockets.get(socket) + " разорвано!");
                    for (Socket tempSocket : sockets.keySet()) {
                        if (!sockets.get(tempSocket).equals("")) {
                            DataOutputStream outAll = new DataOutputStream(tempSocket.getOutputStream());
                            outAll.writeUTF("system >> Чат покинул " + sockets.get(socket) + "!");
                            outAll.flush();
                        }
                    }
                    sockets.remove(socket);
                    Thread.currentThread().interrupt();
                } else if ((pos = line.indexOf("=>")) > 0) {
                    String from = line.substring(0, pos).trim();
                    for (Socket tempSocket : sockets.keySet()) {
                        if (sockets.get(tempSocket).toLowerCase().trim().equals(from)) {
                            DataOutputStream outAll = new DataOutputStream(tempSocket.getOutputStream());
                            outAll.writeUTF(sockets.get(socket) + " >ls> " + line.substring(pos + 2));
                            outAll.flush();
                        }
                    }
                    System.out.println(from + " => " + sockets.get(socket) + " : " + line.substring(pos + 2));
                } else {
                    for (Socket tempSocket : sockets.keySet()) {
                        if ((socket != tempSocket) && (!sockets.get(tempSocket).equals(""))) {
                            DataOutputStream outAll = new DataOutputStream(tempSocket.getOutputStream());
                            outAll.writeUTF(sockets.get(socket) + " >> " + line);
                            outAll.flush();
                        }
                    }
                    System.out.println(sockets.get(socket) + " >> " + line);
                }
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("IOException on socket : " + e);
            e.printStackTrace();
        }

    }

    private Boolean nameInMap(String name, Map<Socket, String> sockets) {
        Boolean result = false;
        for (Socket tempSocket : sockets.keySet()) {
            if (name.toLowerCase().trim().equals(sockets.get(tempSocket))) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

}














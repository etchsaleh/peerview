package model.Client;

import java.io.PrintWriter;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class ClientSocket {

    private static ClientSocket instance = null;

    private Integer port = 4907;

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private ClientSocket (String serverIp) {
        try {
            socket = new Socket(serverIp, port);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
        }
    }

    public static ClientSocket getInstance (String serverIp) {
        if (instance == null) {
            instance = new ClientSocket(serverIp);
        }
        return instance;
    }
    public static ClientSocket getInstance ()throws Exception {
        if (instance == null) {
            throw new Exception("NOT FOUND");
        }
        return instance;
    }

    public void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {

        }
    }
    public String getMessage() {
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            return null;
        }
    }
}
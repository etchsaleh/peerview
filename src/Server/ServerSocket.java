/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.net.ServerSocket;



/**
 *
 * @author omarkhaled
 */
public class ServerSocket {
    private static ServerSocket instance = null;
  
    private int port = 4907;

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ServerSocket () {
        try {
            socket = new java.net.ServerSocket(port).accept();
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Failed connection.");
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
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

    private ServerSocket() {
        try {
            System.out.println("Waiting for Accept");
            socket = new java.net.ServerSocket(port).accept();
            System.out.println("Accept finished");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Failed connection.");
        }
    }
    
    public static ServerSocket getInstance (){
        if (instance == null) {
            instance = new ServerSocket();
        }
        return instance;
    }

    public void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
        }
    }
    
    public void sendImage(BufferedImage image) {
        try {
            ImageIO.write(image, "png", socket.getOutputStream());
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
    
    public BufferedImage getImage() {
        try {
            byte[] bytes = new byte[1024 * 1024];
            int count = 0;
            do {
		count+= socket.getInputStream().read(bytes, count, bytes.length - count);
            } while(!(count > 4 && bytes[count - 2] == (byte) - 1 && bytes[count - 1] == (byte) - 39));
            
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            
            return image;
        } catch (IOException e) {
            return null;
        }
    }
}
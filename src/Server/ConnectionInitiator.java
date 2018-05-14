/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class ConnectionInitiator {

    private static ConnectionInitiator instance = null;
    private ServerSocket socket;
    private String serverPassword;
    private Boolean connected = false;
    
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 
    private ConnectionInitiator(String serverPassword) {
        System.out.println("password");
        this.serverPassword = serverPassword;
    }
    
    public static ConnectionInitiator getInstance (String serverPassword) {
        if (instance == null) {
            instance = new ConnectionInitiator(serverPassword);
        }
        return instance;
    }
    
    public static ConnectionInitiator getInstance () {
        return instance;
    }
    
    public void initiateConnection() {
        socket = ServerSocket.getInstance();
        Authenticator auth = new Authenticator(socket, serverPassword);
        System.out.println("ServerPassword" + serverPassword);
        while(!auth.isValid()) {
            socket.sendMessage("invalid");
        }   
        // auth valid
        socket.sendMessage("valid");
        socket.sendMessage(getWidth());
        socket.sendMessage(getHeight());
        initiateFrameSending();
    }
    
    void initiateFrameSending() {
        Rectangle rect = new Rectangle(dim);
        new SendFrame(rect);
        new ReceiveEvents();
    }
    
    String getWidth() {
        return Double.toString(dim.getWidth());
    }
    String getHeight() {
       return Double.toString(dim.getHeight());
    }
    
    public Boolean isConnected () {
        return connected;
    }
    
}
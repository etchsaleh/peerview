/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;


public class ConnectionInitiator {

    private ServerSocket socket;
    private String serverPassword;

    public ConnectionInitiator(String serverPassword) {
        socket = new ServerSocket();
        this.serverPassword = serverPassword;
    }

    public Boolean initiateConnection() {
        
        Authenticator auth = new Authenticator(socket, serverPassword);
        System.out.print("ServerPassword" + serverPassword);
        while(!auth.isValid()) {
            socket.sendMessage("invalid");
        }
        
        socket.sendMessage("valid");
        return true;
    }
    
   
}

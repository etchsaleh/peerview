/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author omarkhaled
 */
public class Authenticator {
    private ServerSocket socket;
    private String ServerPassword;
    
    public Authenticator(ServerSocket socket, String ServerPassword) {
        this.ServerPassword = ServerPassword;
        this.socket = socket;
    }
         
    public Boolean Authenticate () { 
       String inputPassword = socket.getMessage();
       while(!ServerPassword.equals(inputPassword)) {
           socket.sendMessage("invalid");
           inputPassword = socket.getMessage();
       }
       socket.sendMessage("valid");
       return true;
    }
}

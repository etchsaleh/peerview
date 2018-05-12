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
public class ConnectionInitiator {
    private ServerSocket sck;
    private String serverPassword;
    public ConnectionInitiator(String serverPassword) {
        sck = new ServerSocket();
        this.serverPassword = serverPassword;
    }
    
    public void initiateConnection() {
        
    }
    
   
}

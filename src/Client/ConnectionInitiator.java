/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import javafx.scene.image.ImageView;

/**
 *
 * @author omarkhaled
 */
public class ConnectionInitiator {
    
    private static ConnectionInitiator instance;
    private ClientSocket socket;
    private String clientPassword;
    
   private ConnectionInitiator(String serverIp) throws IOException {
       
        socket = ClientSocket.getInstance(serverIp);
   }
   
   public static ConnectionInitiator getInstance (String serverIp) throws IOException {
       if (instance == null) {
           instance = new ConnectionInitiator(serverIp);
       }
       return instance;
   }
   
   public static ConnectionInitiator getInstance () {
       return instance;
   }
   
   public Boolean checkPassword(String password) {
        Authenticator auth = Authenticator.getInstance(socket);
        return auth.isValid(password);
   }
   
   public void initializeStreaming(ImageView imageView) {
       String width = socket.getMessage();
       String height = socket.getMessage();
       System.out.println("Width " + width);
       System.out.println("Height " + height);
       new ReceiveFrame(imageView);
       new EventSender(imageView, Double.parseDouble(width), Double.parseDouble(height));
   }
   
}
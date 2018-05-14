/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Administrator
 */
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;



public class ReceiveFrame extends Thread {

    private ImageView imageView;
    
    public ReceiveFrame(ImageView imageView) {
        System.out.println("ReceiveFrame");
        
        this.imageView = imageView;
        start();
    }

    public void run() {
        
        try {
            while (true) {
              BufferedImage image = ClientSocket.getInstance().getImage();  
              WritableImage imageFx = SwingFXUtils.toFXImage(image, null);
              this.imageView.setImage(imageFx);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

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
import java.awt.*;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;



public class ReceiveFrame extends Thread {

    private ImageView imageView;
    
    public ReceiveFrame(ImageView imageView) {
        this.imageView = imageView;
        start();
    }

    public void run() {
        
        try {
            while (true) {
//              System.out.println("In Image loop");
              BufferedImage image = ClientSocket.getInstance().getImage();  
//              System.out.println("In Image loop 2");
              WritableImage imageFx = SwingFXUtils.toFXImage(image, null);
//              System.out.println("In Image loop 3");
              this.imageView.setImage(imageFx);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

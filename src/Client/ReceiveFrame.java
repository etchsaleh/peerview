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
import Server.ServerSocket;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

public class ReceiveFrame extends Thread {

    private ImageView imageView;
    
    public ReceiveFrame(ImageView imageView) {
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

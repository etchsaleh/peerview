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
import javax.imageio.ImageIO;

class ReceiveFrame extends Thread {
    
	public ReceiveFrame(){
            start();
	}

	public void run(){
            try{
                while(true){
                    BufferedImage image = ClientSocket.getInstance().getImage();
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.ClientSocket;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

public class SendFrame extends Thread {
    
    Robot robot = null;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle rectangle = new Rectangle(screenSize);

    public SendFrame(Robot robot, Rectangle rect) {
        this.robot = robot;
        this.rectangle = rect;
        start();
    }
    
    public void run(){
	while(true){
            BufferedImage image = robot.createScreenCapture(rectangle);
            try {
                ServerSocket.getInstance().sendImage(image);
            } catch(Exception ex){
                ex.printStackTrace();
            }
            
            try {
                Thread.sleep(10);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


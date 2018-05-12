/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

public class ServerSendScreen extends Thread {
    
    Socket socket = null;
    Robot robot = null;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle rectangle = new Rectangle(screenSize);
    boolean continueLoop = true;
    OutputStream OutStream = null;

    public ServerSendScreen(Socket socket, Robot robot, Rectangle rect) {
        this.socket = socket;
        this.robot = robot;
        this.rectangle = rect;
        start();
    }
    
    public void run(){
	try {
            OutStream = socket.getOutputStream();
	} catch(IOException ex){
            ex.printStackTrace();
	}
	while(continueLoop){
            BufferedImage image = robot.createScreenCapture(rectangle);
            try {
                ImageIO.write(image, "png", OutStream);
            } catch(IOException ex){
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


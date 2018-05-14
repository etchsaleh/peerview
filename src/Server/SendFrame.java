/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;


public class SendFrame extends Thread {
    
    Robot robot = null;
    Rectangle rect;
    
    public SendFrame(Rectangle rect) {
        System.out.println("SendFrame");
        
        this.rect = rect;
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
        try {
            robot = new Robot(gDev);
        } catch(Exception e) { 
            System.out.println(e);
        }
        start();
    }
    
    public void run(){
	while(true){
            BufferedImage image = robot.createScreenCapture(rect);
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


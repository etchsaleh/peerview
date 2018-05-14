
package Server;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author loay
 */
public class ReceiveEvents extends Thread {

    Robot robot = null;
    private ServerSocket socket;
    
    public void ReceiveEvents() {
        socket = ServerSocket.getInstance();
        
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
        
        try {
            robot = new Robot(gDev);
        } catch(Exception e) { 
            System.out.println(e);
        }

        start();
    }
    
    @Override
    public void run(){
	try {
            int param1 = Integer.parseInt(socket.getMessage());
            while(true){
                String command = socket.getMessage();
                switch (command) {
                    case "MP":
                        robot.mousePress(param1);
                        System.out.println(robot);
                        break;
//                    case "MR":
//                        robot.mouseRelease(param1);
//                        break;
                    case "MV":
                        robot.mouseMove(param1,Integer.parseInt(socket.getMessage()));
                        break;
                    case "KP":
                        robot.keyPress(param1);
                        break;
                    case "KR":
                        robot.keyRelease(param1);
                        break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
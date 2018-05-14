
package Server;

import java.awt.DefaultKeyboardFocusManager;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.Object;
import java.lang.reflect.Field;

/**
 *
 * @author loay
 */
public class ReceiveEvents extends Thread {

    Robot robot;
    private ServerSocket socket;
    
    public ReceiveEvents() {
        System.out.println("ReceiveEvents");
        
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
    
    public void run(){
	try {
            System.out.print("here");
            while(true){
                String command = socket.getMessage();
                System.out.println("Command: " + command);
                switch (command) {
                    case "MP":
                        int press = Integer.parseInt(socket.getMessage());
                        int mask_p = InputEvent.getMaskForButton(press);
                        robot.mousePress(mask_p);
                        break;
                    case "MR":
                        int release = Integer.parseInt(socket.getMessage());
                        int mask_r = InputEvent.getMaskForButton(release);
                        robot.mouseRelease(mask_r);
                        break;
                    case "MV":
                        double pos1 = Double.parseDouble(socket.getMessage());
                        double pos2 = Double.parseDouble(socket.getMessage());
                        robot.mouseMove((int)pos1, (int)pos2);
                        break;
                    case "KP":
                        String letter = Character.toString(socket.getMessage().charAt(0));
                        String code = "VK_" + letter;
                        Field f = KeyEvent.class.getField(code);
                        int keyEvent = f.getInt(null);
                        robot.keyPress(keyEvent);
                        break;
                    case "KR":
                        String letter1 = Character.toString(socket.getMessage().charAt(0));
                        String code1 = "VK_" + letter1;
                        Field f1 = KeyEvent.class.getField(code1);
                        int keyEvent1 = f1.getInt(null);
                        robot.keyRelease(keyEvent1);
                        break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
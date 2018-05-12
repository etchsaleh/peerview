
package Server;

import java.awt.Robot;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author loay
 */
public class ReceiveEvents extends Thread {
    Socket socket= null;
    Robot robot = null;
    boolean continueLoop = true;
    public void ReceiveEvents(Socket socket, Robot robot){
            this.socket = socket;
            this.robot = robot;
            start();
	}
    @Override
    public void run(){
        Scanner scanner = null;
	try {
            scanner = new Scanner(socket.getInputStream());
            int param1 = Integer.parseInt(scanner.next());
            while(continueLoop){
                String command = scanner.next();
                switch (command) {
                        case "MP":
                            robot.mousePress(param1);
                            break;
                        case "MR":
                            robot.mouseRelease(param1);
                            break;
                        case "MM":
                            robot.mouseMove(param1,Integer.parseInt(scanner.next()));
                            break;
                        case "KP":
                            robot.keyPress(param1);
                            break;
                        case "KR":
                            robot.keyRelease(param1);
                            break;
                            }
                    }
            }
        catch(IOException ex){ex.printStackTrace();}
        }
}
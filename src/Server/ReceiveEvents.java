
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
            while(continueLoop){
                String command = scanner.next();
                switch (command) {
                        case "MP":
                            robot.mousePress(scanner.nextInt());
                            break;
                        case "MR":
                            robot.mouseRelease(scanner.nextInt());
                            break;
                        case "MM":
                            robot.mouseMove(scanner.nextInt(),scanner.nextInt());
                            break;
                        case "KP":
                            robot.keyPress(scanner.nextInt());
                            break;
                        case "KR":
                            robot.keyRelease(scanner.nextInt());
                            break;
                            }
                    }
            }
        catch(IOException ex){ex.printStackTrace();}
        }
}
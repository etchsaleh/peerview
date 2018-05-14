package Client;

import javax.swing.*;
import java.net.Socket;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class EventSender {

    private ClientSocket socket;
    private ImageView panel;
    private double widthServer, heightServer, widthClient, heightClient;
    private MouseHandler mouseHandler = null;
    
    EventSender(ImageView panel, double widthServer, double heightServer) {
        this.socket = ClientSocket.getInstance();
        this.panel = panel;
        this.widthServer = widthServer;
        this.heightServer = heightServer;
        this.widthClient = panel.getFitWidth();
        this.heightClient = panel.getFitHeight();
        mousePressed();
        mouseMoved();
        keyPressed();
        keyReleased();
    }
    
    private void mousePressed() {
        panel.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            socket.sendMessage("MP");
            socket.sendMessage(Integer.toString(event.getButton().ordinal()));
//            System.out.println("mouse pressed");
        });
    }
    
    private void mouseMoved() {
        panel.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            double newX = (double)widthServer / widthClient * event.getX();
            double newY = (double)heightServer / heightClient * event.getY();
            socket.sendMessage("MV");
            socket.sendMessage(Double.toString(newX));
            socket.sendMessage(Double.toString(newY));
            //System.out.println("mouse move");
        });
    }
    
    private void keyPressed() {
        panel.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            socket.sendMessage("KP");
            socket.sendMessage(Integer.toString(event.getCode().ordinal()));
            //System.out.println("key pressed");
        });
    }
    
    private void keyReleased() {
        panel.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            socket.sendMessage("KR");
            socket.sendMessage(Integer.toString(event.getCode().ordinal()));
//            System.out.println("key released");
        });
    }
}

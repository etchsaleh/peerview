package Client;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class EventSender {

    private ClientSocket socket;
    private ImageView panel;
    private double widthServer, heightServer, widthClient, heightClient;
    
    EventSender(ImageView panel, double widthServer, double heightServer) {
        System.out.println("EventSender");
        this.socket = ClientSocket.getInstance();
        this.panel = panel;
        this.widthServer = widthServer;
        this.heightServer = heightServer;
        this.widthClient = panel.getFitWidth();
        this.heightClient = panel.getFitHeight();
        
        panel.setFocusTraversable(true);
        
        mouseMoved();
        mouseReleased();
        mousePressed();
        keyPressed();
        keyReleased();
    }
    
    private void mousePressed() {
        panel.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            socket.sendMessage("MP");
            socket.sendMessage(Integer.toString(event.getButton().ordinal()));
            System.out.println("Client mouse pressed" + Integer.toString(event.getButton().ordinal()));
        });
    }
    
    private void mouseReleased() {
        panel.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            socket.sendMessage("MR");
            socket.sendMessage(Integer.toString(event.getButton().ordinal()));
            System.out.println("Client mouse released" + Integer.toString(event.getButton().ordinal()));
        });
    }
    
    private void mouseMoved() {
        panel.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            double newX = (double)widthServer / widthClient * event.getX();
            double newY = (double)heightServer / heightClient * event.getY();
            socket.sendMessage("MV");
            socket.sendMessage(Double.toString(newX));
            socket.sendMessage(Double.toString(newY));
            System.out.println("Client mouse move");
        });
    }
    
    private void keyPressed() {
        panel.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            socket.sendMessage("KP");
            socket.sendMessage(event.getCode().getName());
            System.out.println("Client key pressed");
        });
    }
    
    private void keyReleased() {
        panel.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            socket.sendMessage("KR");
            socket.sendMessage(event.getCode().getName());
            System.out.println("Client key released");
        });
    }
}


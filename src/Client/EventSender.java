package Client;

import javax.swing.*;
import java.net.Socket;

public class EventSender {

    private ClientSocket socket ;
    private JPanel panel;
    private double widthServer,heightServer;
    private MouseHandler mouseHandler = null;
    EventSender(JPanel panel ,double widthClient , double heightClient , double widthServer , double heightServer) throws Exception {
        this.socket = ClientSocket.getInstance();
        this.panel = panel;
        this.widthServer = widthServer;
        this.heightServer = heightServer;
        panel.addMouseListener(new MouseHandler(widthClient,heightClient,widthServer,heightServer));
        panel.addKeyListener(new KeyboardHandler());
    }
}

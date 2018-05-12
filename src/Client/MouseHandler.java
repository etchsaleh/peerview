package Client;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.PrintWriter;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private ClientSocket socket = null;
    private JPanel panel;
    private double widthServer,heightServer;
    MouseHandler(JPanel panel , double widthServer , double heightServer) throws Exception
    {
        this.socket = ClientSocket.getInstance();
        this.panel = panel;
        this.widthServer = widthServer;
        this.heightServer = heightServer;
        panel.addMouseListener(this);
    }
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double newX = (double)widthServer/panel.getWidth() * mouseEvent.getX();
        double newY = (double)heightServer/panel.getHeight() * mouseEvent.getY();
        socket.sendMessage("MV");
        socket.sendMessage(Double.toString(newX));
        socket.sendMessage(Double.toString(newY));
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        socket.sendMessage("MP");
        socket.sendMessage(Integer.toString( mouseEvent.getButton()));
    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {


    }
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
package Client;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.PrintWriter;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private ClientSocket socket = null;
    
    private double widthServer,heightServer,widthClient,heightClient;
    MouseHandler( double widthClient , double heightClient ,double widthServer , double heightServer) throws Exception
    {
        this.socket = ClientSocket.getInstance();
        this.widthServer = widthServer;
        this.heightServer = heightServer;
        this.widthClient = widthClient;
        this.heightClient = heightClient;
    }
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        double newX = (double)widthServer/widthClient * mouseEvent.getX();
        double newY = (double)heightServer/heightClient * mouseEvent.getY();
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
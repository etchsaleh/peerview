//package Client;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import javax.swing.*;
//import java.net.Socket;
//
//public class KeyboardHandler implements KeyListener {
//
//    private ClientSocket socket = null;
//    KeyboardHandler() throws Exception {
//        this.socket = ClientSocket.getInstance();
//    }
//
//    @Override
//    public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ke) {
//        socket.sendMessage("KP");
//        socket.sendMessage(Integer.toString(ke.getKeyCode()));
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
//        socket.sendMessage("KR");
//        socket.sendMessage(Integer.toString(ke.getKeyCode()));
//    }
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Server.ServerSocket;
import Server.SendFrame;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.net.Socket;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class ClientFramesViewController implements Initializable {

    @FXML
    private ImageView imageView;
    
    @FXML
    private AnchorPane rootPane;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.print("hola");
        Image image = new Image(ClientFramesViewController.class.getResourceAsStream("smile.jpg"));
        try{
            imageView.setImage(image);
        } catch (Exception ex) {
            System.out.print(ex);
        }
        
//        try {
//        
//            GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
//
//            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//
//            Socket socket = new Socket();
//            Rectangle rect = new Rectangle(dim);
//            Robot robot = new Robot(gDev);
//            
//            
//        
//        } catch (Exception ex) {
//            
//        }
        
        
    }    
    
}

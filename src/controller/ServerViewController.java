/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Server.ConnectionInitiator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HeshamSaleh
 */
public class ServerViewController implements Initializable {

    @FXML
    private TextField passwordTextField;
    @FXML
    private Button setPasswordBtn;
    @FXML
    private Label ipAddressLbl;
    @FXML
    private AnchorPane rootPane;
    
    public Server.ConnectionInitiator connectionInitiator;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Retrieving Server IP address.
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            ipAddressLbl.setText(ipAddress);
            System.out.print(ipAddressLbl);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void setPasswordPressed(ActionEvent event) throws IOException {
        String password = passwordTextField.getText();
        System.out.println("Password is " + password);
        
        if (password.length() != 0) {
        
            //Awaiting Client connection.
            AnchorPane pane = FXMLLoader.load(ServerViewController.this.getClass().getResource("/view/ScreenView.fxml"));
            rootPane.getChildren().setAll(pane);
            
            connectionInitiator = new Server.ConnectionInitiator(password);
        }
    }
}

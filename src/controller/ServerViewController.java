/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Retrieving Server IP address.
        try {
            ipAddressLbl.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void setPasswordPressed(ActionEvent event) {
        System.out.println("Password is " + passwordTextField.getText());
    }
    
}

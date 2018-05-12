/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Client.ClientSocket;

/**
 * FXML Controller class
 *
 * @author HeshamSaleh
 */
public class ClientViewController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button submitBtn;
    @FXML
    private TextField ipAddressTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitBtnPressed(ActionEvent event) {
        
        String serverIp = ipAddressTextField.getText();
        
        ClientSocket.getInstance(serverIp);
        System.out.println(serverIp);
        
        
        if(ClientSocket.correctIP == true) {
            System.out.println("Established connection");
        } else {
            System.out.println("Failed to connect");
        }
    }
    
}

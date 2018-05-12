
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
import javafx.fxml.FXMLLoader;
import java.io.IOException;

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
    @FXML
    private TextField serverPasswordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitBtnPressed(ActionEvent event) throws IOException {
        

        AnchorPane pane = FXMLLoader.load(ClientViewController.this.getClass().getResource("/view/ClientFramesView.fxml"));
        rootPane.getChildren().setAll(pane);
        
//        ClientSocket.getInstance(serverIp);
//        System.out.println(serverIp);
//        
//        
//        if(ClientSocket.correctIP == true) {
//            System.out.println("Established connection");
//        } else {
//            System.out.println("Failed to connect");
//        }
    }
    
}

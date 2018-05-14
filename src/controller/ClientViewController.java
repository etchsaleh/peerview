
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Client.ConnectionInitiator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HeshamSaleh
 */
public class ClientViewController implements Initializable {

    @FXML
    private Button submitBtn;
    @FXML
    private TextField ipAddressTextField;
    @FXML
    private TextField serverPasswordField;
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        @FXML
    private void submitBtnPressed(ActionEvent event) throws IOException {
        
        String serverIp = ipAddressTextField.getText();
        String password = serverPasswordField.getText();
        
        ConnectionInitiator connInit = ConnectionInitiator.getInstance(serverIp);
        
        System.out.println(serverIp);
        
        if(connInit.checkPassword(password)) {
            
            Parent pane = FXMLLoader.load(ClientViewController.this.getClass().getResource("/view/ClientFramesView.fxml"));
            
            Stage mainStage = (Stage) submitBtn.getScene().getWindow();
            mainStage.close();
            
            Stage stage = new Stage();
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Connected to " + serverIp);
            stage.show();
            
        } 
    }
    
}
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
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author HeshamSaleh
 */

public class StartViewController implements Initializable {
    
    @FXML
    private Button controlRemoteBtn;

    @FXML
    private Button allowRemoteBtn;

    @FXML
    void allowRemotePressed(ActionEvent event) {
        //AnchorPane pane = FXMLLoader.load(ServerController.this.getClass().getResource("/fxml/ServerView.fxml"));
        //rootPane.getChildren().setAll(pane);
    }

    @FXML
    void controlRemotePressed(ActionEvent event) {
        //AnchorPane pane = FXMLLoader.load(ClientController.this.getClass().getResource("/fxml/ClientView.fxml"));
        //rootPane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

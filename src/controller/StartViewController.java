/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private AnchorPane rootPane;

    @FXML
    void allowRemotePressed(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(StartViewController.this.getClass().getResource("/view/ServerView.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void controlRemotePressed(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(StartViewController.this.getClass().getResource("/view/ClientView.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

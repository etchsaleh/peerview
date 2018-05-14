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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


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
    private VBox vBox;
    
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

    @FXML
    private void controlRemoteBtnExitHover(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setScaleX(1); btn.setScaleY(1);
        btn.setStyle("-fx-background-color: #8DA6C0; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1; -fx-border-color: #74899F");
    }

    @FXML
    private void controlRemoteBtnHover(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setScaleX(1.02); btn.setScaleY(1.02);
        btn.setStyle("-fx-background-color: #A2C1DF; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1; -fx-border-color: #74899F");
    }

    @FXML
    private void allowRemoteBtnExitHover(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setScaleX(1); btn.setScaleY(1);
        btn.setStyle("-fx-background-color: #191919; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1; -fx-border-color: #5B5B5B");
    }

    @FXML
    private void allowRemoteBtnHover(MouseEvent event) {
        Button btn = (Button) event.getSource();
        btn.setScaleX(1.02); btn.setScaleY(1.02);
        btn.setStyle("-fx-background-color: #000000; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-width: 1; -fx-border-color: #5B5B5B");
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Server.ConnectionInitiator;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HeshamSaleh
 */
public class ScreenViewController implements Initializable {

    @FXML
    private Label awaitingConnLbl;
    @FXML
    private AnchorPane rootPane;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        Executors.newSingleThreadExecutor().execute(() -> {
            ConnectionInitiator connectInit = ConnectionInitiator.getInstance();
            connectInit.initiateConnection();
            
            Platform.runLater(() -> {
                Stage stage = (Stage) awaitingConnLbl.getScene().getWindow();
                stage.close();
            });
        });
        
        // System.out.println("After Blocking");
        
    }
}
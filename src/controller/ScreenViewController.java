
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
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author HeshamSaleh
 */
public class ScreenViewController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ConnectionInitiator connectInit = ConnectionInitiator.getInstance();
                connectInit.initiateConnection();
                
 
            }
        });
        System.out.println("After Blocking");
    }
}
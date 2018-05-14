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
import javafx.scene.layout.VBox;

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
    @FXML
    private VBox vBox;
    
    public Server.ConnectionInitiator connectionInitiator;
  
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Retrieving Server IP address.
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            ipAddressLbl.setText(ipAddress);
            
            System.out.print("IP: " + ipAddress + "\n");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void setPasswordPressed(ActionEvent event) throws IOException {
        String password = passwordTextField.getText();
        System.out.println("Password is " + password);
        
        ConnectionInitiator connInit = ConnectionInitiator.getInstance(password);

        AnchorPane pane = FXMLLoader.load(ServerViewController.this.getClass().getResource("/view/ScreenView.fxml"));
        rootPane.getChildren().setAll(pane);
        
    }
}
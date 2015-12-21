/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.kinoreservation.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Phillip.Thomas
 */
public class FrmMenuController implements Initializable {
    
    @FXML
    private Button btnReservationErstellen;
    
    @FXML
    private Button btnReservationAnzeigen;
    
    
    private void showUserControl() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/java/kinoreservation/usercontrol/FrmUserControl.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    private void btnReservationErstellen_Clicked() throws IOException {
        this.showUserControl();
    }
    
    @FXML
    private void btnReservationAnzeigen_Clicked() {
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}

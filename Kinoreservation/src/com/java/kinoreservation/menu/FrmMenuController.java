/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.kinoreservation.menu;

import com.java.kinoreservation.core.UserReservationCollection;
import com.java.kinoreservation.reservation.FrmReservationController;
import com.java.kinoreservation.usercontrol.FrmUserControlController;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
    
    @FXML private Button btnReservationErstellen;
    @FXML private Button btnReservationAnzeigen;
    
    private void showUserControl() throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/kinoreservation/usercontrol/FrmUserControl.fxml"));
        Parent root = (Parent)loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        
        FrmUserControlController controller = (FrmUserControlController)loader.getController();

    }
    
    private void showReservations() throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/kinoreservation/reservation/FrmReservation.fxml"));
        Parent root = (Parent)loader.load();
        
        FrmReservationController controller = (FrmReservationController)loader.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        controller.setTakenSeats(UserReservationCollection.getInstance().getAllTakenSeats());
        controller.preview();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        
        stage.showAndWait();
        
        
    }
    
    @FXML private void btnReservationErstellen_Clicked() throws IOException {
        this.showUserControl();
    }
    
    @FXML private void btnReservationAnzeigen_Clicked() throws IOException {
         this.showReservations();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}

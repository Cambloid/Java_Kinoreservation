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
    
    private Stage stage = null;
    
    @FXML private Button btnReservationErstellen;
    @FXML private Button btnReservationAnzeigen;
    
    private void showUserControl() throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/kinoreservation/usercontrol/FrmUserControl.fxml"));
        Parent root = (Parent)loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        FrmUserControlController controller = (FrmUserControlController)loader.getController();
        controller.setStage(stage);
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
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
    
    public void setStage(Stage stage) {
        this.stage = stage;        
    }
    
    @FXML private void btnReservationErstellen_Clicked() throws IOException {
        this.showUserControl();
    }
    
    @FXML private void btnClose_Clicked() {
        if(this.stage != null) {
            this.stage.close();
        }
    }
    
    @FXML private void btnReservationAnzeigen_Clicked() throws IOException {
         this.showReservations();
    }
    
    @Override public void initialize(URL url, ResourceBundle rb) {
        
    }
}

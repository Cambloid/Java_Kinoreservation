/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.kinoreservation.usercontrol;

import com.java.kinoreservation.core.ReservationInfo;
import com.java.kinoreservation.core.UserReservationCollection;
import com.java.kinoreservation.reservation.FrmReservationController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Phillip.Thomas
 */
public class FrmUserControlController implements Initializable {
    
    @FXML private Button btnAddPerson;
    @FXML private TextField txtVorname;
    @FXML private TextField txtNachname;
    
    private void showReservation() throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/kinoreservation/reservation/FrmReservation.fxml"));
        Parent root = (Parent)loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        
        FrmReservationController controller = (FrmReservationController)loader.getController();
        
        ReservationInfo info = new ReservationInfo();
        
        info.setVorname(txtVorname.getText());
        info.setNachname(txtNachname.getText());
        
        UserReservationCollection.getInstance().addReservation(info);
        
    }
    
    @FXML
    private void btnAddPerson_Clicked() throws IOException {
        this.showReservation();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

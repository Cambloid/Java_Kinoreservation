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
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Phillip.Thomas
 */
public class FrmUserControlController implements Initializable {
    
    @FXML private Button    btnAddPerson;
    @FXML private Button    btnRemovePerson;
    @FXML private TextField txtVorname;
    @FXML private TextField txtNachname;
    @FXML private ListView<String> lstKunden;
    
    private FrmReservationController controller = null;
    
    private void fillList() {
       ObservableList<String> items = lstKunden.getItems();
       items.clear();
       
       for(ReservationInfo info : UserReservationCollection.getInstance().getReservations()) {
           int i = 1;
           String sitz = "Sitz: ";
           for(boolean takenSeat : info.getSeats()) {
               if(takenSeat) {
                   if(i == 1) {
                     sitz += Integer.toString(i);
                   } else {
                       sitz += "," + Integer.toString(i);
                   }
               }
               i++;
           }
           
           items.add(info.getVorname() + " " + info.getNachname() + " " + sitz);
       }
       
    }
    
    private void clearFiels() {
        this.txtVorname.setText("");
        this.txtNachname.setText("");
    }
    
    private boolean validateFields() {
        boolean valid = true;
        String msg = "Die folgenden Felder dürfen nicht leer sei:\r\n";
        
        if(this.txtVorname.getText().equals("")) {
            msg += "Vorname\r\n";
            valid = false;
        }
        
        if(this.txtNachname.getText().equals("")) {
            msg += "Nachname\r\n"; 
            valid = false;
        }
        
        if(!valid) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setContentText(msg);
            alert.showAndWait();
        }
        
        return valid;        
    }
    
    private void addPerson() {
        
            ReservationInfo info = new ReservationInfo();
        
            info.setVorname(txtVorname.getText());
            info.setNachname(txtNachname.getText());
            info.setSeats(controller.getSeats());
        
            UserReservationCollection.getInstance().addReservation(info);
            
    }
    
    private void showReservation() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/java/kinoreservation/reservation/FrmReservation.fxml"));
        Parent     root   = (Parent)loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        
        this.controller = (FrmReservationController)loader.getController();
        this.controller.setStage(stage);
        this.controller.setTakenSeats(UserReservationCollection.getInstance().getAllTakenSeats());
        
        stage.showAndWait();
        
    }
    
    @FXML private void btnAddPerson_Clicked() throws IOException {
        if(this.validateFields()) {
            this.showReservation();
            this.addPerson();
            this.clearFiels();
            this.fillList();
        }
    }
   
    @FXML private void btnRemovePerson_Clicked() throws IOException {
        if(this.lstKunden.getSelectionModel().getSelectedIndex() != -1) {
            int index = this.lstKunden.getSelectionModel().getSelectedIndex();
            UserReservationCollection.getInstance().removeReservation(index);
            this.fillList();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

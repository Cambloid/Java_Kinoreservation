/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.kinoreservation.reservation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Phillip.Thomas
 */
public class FrmReservationController implements Initializable {
    
    private boolean preview = false;
    
    private Stage stage = null;
    
    private boolean[] taken = {
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
    };
    
    private boolean[] customer = {
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
    };
    
    @FXML private Button btnS1;
    @FXML private Button btnS2;
    @FXML private Button btnS3;
    @FXML private Button btnS4;
    @FXML private Button btnS5;
    @FXML private Button btnS6;
    @FXML private Button btnS7;
    @FXML private Button btnS8;
    @FXML private Button btnS9;
    @FXML private Button btnS10;    
    @FXML private Button btnSave;
    
    private void setState(Button btn, int index) {
        if(!preview) {
            if(btn.getStyle().equals("-fx-background-color: lightgreen;")) {
                btn.setStyle("-fx-background-color: yellow;");
                this.customer[index] = true;
            } else {
                btn.setStyle("-fx-background-color: lightgreen;");
                this.customer[index] = false;
            }
        }
    }
    
    @FXML private void btnS1_Clicked() {
        if(!this.taken[0]) {
            this.setState(btnS1, 0);
        }
    }
    
    @FXML private void btnS2_Clicked() {
        if(!this.taken[1]) {
            this.setState(btnS2, 1);
        }
    }
    
    @FXML private void btnS3_Clicked() {
        if(!this.taken[2]) {
            this.setState(btnS3, 2);
        }
    }
    
    @FXML private void btnS4_Clicked() {
        if(!this.taken[3]) {
            this.setState(btnS4, 3);
        }
    }
    
    @FXML private void btnS5_Clicked() {
        if(!this.taken[4]) {
            this.setState(btnS5, 4);
        }
    }
    
    @FXML private void btnS6_Clicked() {
        if(!this.taken[5]) {
            this.setState(btnS6, 5);
        }
    }
    
    @FXML private void btnS7_Clicked() {
        if(!this.taken[6]) {
            this.setState(btnS7, 6);
        } 
    }
    
    @FXML private void btnS8_Clicked() {
        if(!this.taken[7]) {
            this.setState(btnS8, 7);
        }
    }
    
    @FXML private void btnS9_Clicked() {
        if(!this.taken[8]) {
            this.setState(btnS9, 8);
        }
    }
    
    @FXML private void btnS10_Clicked() {
        if(!this.taken[9]) {
            this.setState(btnS10, 9);
        }
    }
    
    @FXML private void btnSave_Clicked() {
        if(stage != null) {
            stage.close();
        }
     }
    
    @Override public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public boolean[] getSeats() {
        return this.customer;
    }
    
    public void preview() {
        this.btnSave.setVisible(false);
        this.preview = true;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void setTakenSeats(boolean[] takenSeats) {
        
        this.taken = takenSeats;
        
        if(takenSeats[0]) {
            this.btnS1.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[1]) {
            this.btnS2.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[2]) {
            this.btnS3.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[3]) {
            this.btnS4.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[4]) {
            this.btnS5.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[5]) {
            this.btnS6.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[6]) {
            this.btnS7.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[7]) {
            this.btnS8.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[8]) {
            this.btnS9.setStyle("-fx-background-color: red;");
        }
        if(takenSeats[9]) {
            this.btnS10.setStyle("-fx-background-color: red;");
        }
    }
}

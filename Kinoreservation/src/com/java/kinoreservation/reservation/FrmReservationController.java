/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.kinoreservation.reservation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Phillip.Thomas
 */
public class FrmReservationController implements Initializable {
    
    
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
    
    private void setState(Button btn) {
       if(btn.getStyle().equals("-fx-background-color: lightgreen;")) {
            btn.setStyle("-fx-background-color: yellow;");
       } else {
           btn.setStyle("-fx-background-color: lightgreen;");
       }
    }
    
    
    @FXML
    private void btnS1_Clicked() {
        this.setState(btnS1);
    }
    @FXML
    private void btnS2_Clicked() {
        this.setState(btnS2);
    }
    @FXML
    private void btnS3_Clicked() {
        this.setState(btnS3);
    }
    @FXML
    private void btnS4_Clicked() {
        this.setState(btnS4);
    }
    @FXML
    private void btnS5_Clicked() {
        this.setState(btnS5);
    }
    @FXML
    private void btnS6_Clicked() {
        this.setState(btnS6);
    }
    @FXML
    private void btnS7_Clicked() {
        this.setState(btnS7);
    }
    @FXML
    private void btnS8_Clicked() {
        this.setState(btnS8);
    }
    @FXML
    private void btnS9_Clicked() {
        this.setState(btnS9);
    }
    @FXML
    private void btnS10_Clicked() {
        this.setState(btnS10);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

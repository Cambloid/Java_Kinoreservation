/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.kinoreservation.core;

import java.util.ArrayList;

/**
 *
 * @author Celvin
 */
public class ReservationsInfo {
    
    private String             vorname;
    private String             nachname;
    private ArrayList<Integer> sitzNummer = new ArrayList<Integer>();
    
    public ReservationsInfo() {  }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public ArrayList<Integer> getSitze() {
        return this.sitzNummer;
    }
    
}

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
public class UserReservationCollection {
    
    private ArrayList<ReservationInfo>       reservationCollection = new ArrayList<ReservationInfo>();
    private static UserReservationCollection instance              = null;
    
    private UserReservationCollection() {
        
    }
    
    public static UserReservationCollection getInstance() {
        if(UserReservationCollection.instance == null) {
            UserReservationCollection.instance = new UserReservationCollection();
        }
        return UserReservationCollection.instance;
    }
    
    public ArrayList<ReservationInfo> getReservations() {
        return this.reservationCollection;
    }
    
    public void addReservation(ReservationInfo Info) {
        this.reservationCollection.add(Info);
    }
    
    public void removeReservation(int index) {
        this.reservationCollection.remove(index);
    }
    
    public boolean[] getAllTakenSeats() {
        boolean[] takenSeats = {
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
        for(ReservationInfo info : this.reservationCollection) {
            int index = 0;
            for(boolean takenSeat : info.getSeats()) {
                if(takenSeat) {
                    takenSeats[index] = true;
                }
                index++;
            }
        }
        
        return takenSeats;
    }
}

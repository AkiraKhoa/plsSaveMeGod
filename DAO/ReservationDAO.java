package DAO;

import entities.Reservation;
import java.util.HashMap;
import utilities.Tool;

public class ReservationDAO {
     private HashMap<String, Reservation> reservations;  

    public ReservationDAO() {
        this.reservations = new HashMap<>();
    }

    public Reservation getReservation(String reservationId) {
        return reservations.get(reservationId);
    }

    public void addReservation(Reservation reservation) {
        reservations.put(reservation.getReservationId(), reservation);
    }

    public void updateReservation(String reservationId, Reservation updatedReservation) {
        reservations.put(reservationId, updatedReservation);
    }

    public void deleteReservation(String reservationId) {
        reservations.remove(reservationId);
    }
    
    public void save(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation cannot be null");
        }
        reservations.put(reservation.getReservationId(), reservation);
        System.out.println("Reservation successfully made! Your reservation ID is: " + reservation.getReservationId());
    }
    

    public boolean existsReservationID(String ReservationID) {
        boolean check = true;
        if (reservations.containsKey(ReservationID)) {
            System.out.println("Flight with ID: " + ReservationID + " already exists!");
            check = false;
        }
        return check;
    }
   
    public String getReservationID (){
        while(true){
            String input = Tool.validateReservationID("Enter your reservation ID: ", "Invalid input. Please try again.");
            if(existsReservationID(input)) return input;
            System.out.println("that Reservation ID never generated");
        }
    }
    
}

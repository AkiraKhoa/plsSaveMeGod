package services;

import DAO.FlightDAO;
import DAO.ReservationDAO;
import entities.Flight;
import entities.Reservation;
import utilities.Tool;

public class CheckInService {
    private ReservationDAO reservationDAO;
    private FlightDAO flightDAO;

    public CheckInService(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public void checkInPassenger(String reservationId) {
        Reservation reservation = reservationDAO.getReservation(reservationId);
        // Logic for check-in, seat allocation, and generating boarding pass.
    }
    
    public void checkIn() {
    // 1. Prompt for Reservation ID
    
    String reservationId = reservationDAO.getReservationID();
    Reservation reservation = reservationDAO.getReservation(reservationId);
    // 2. Display Flight Seating
    Flight flightForReservation = reservation.getFlight();
    flightDAO.displaySeats(flightForReservation);

    // 3. Seat Selection
    int maxSeats = flightForReservation.getSeatNumber(); // Assuming this is the total number of seats
    int chosenSeat = Tool.validateIntRange("Choose an available seat by entering its number: ", 1, maxSeats, "Invalid choice. Please select a valid seat number.", false);

    while (flightForReservation.isSeatTaken(chosenSeat)) {
        System.out.println("This seat is already reserved. Please choose another seat.");
        chosenSeat = Tool.validateIntRange("Choose an available seat by entering its number: ", 1, maxSeats, "Invalid choice. Please select a valid seat number.", false);
    }
    flightForReservation.reserveSeat(chosenSeat); // Assuming Flight has a method to mark a seat as reserved

    // 4. Confirmation
    System.out.println("Your seat has been successfully reserved. Your chosen seat number is: " + chosenSeat);
}


    // Other methods related to check-in and seat allocation
}

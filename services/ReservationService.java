package services;

import DAO.FlightDAO;
import DAO.PassengerDAO;
import DAO.ReservationDAO;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import utilities.Tool;


public class ReservationService {
    private ReservationDAO reservationDAO;
    private PassengerDAO passengerDAO;
    private FlightDAO flightDAO;


    public ReservationService(ReservationDAO reservationDAO, PassengerDAO passengerDAO) {
        this.reservationDAO = reservationDAO;
        this.passengerDAO = passengerDAO;
    }

    public void makeReservation(Reservation reservation, Passenger passenger) {
        reservationDAO.addReservation(reservation);
        passengerDAO.addPassenger(passenger);
    }

    public Reservation getReservation(String reservationId) {
        return reservationDAO.getReservation(reservationId);
    }
    
    public void makeReservation() {
        System.out.println("---- Make a Flight Reservation ----");
        String departureLocation = Tool.validateAlphanumericString("Enter departure location: ", "Invalid location.", false);
        String arrivalLocation = Tool.validateAlphanumericString("Enter arrival location: ", "Invalid location.", false);
        LocalDateTime desiredDate = Tool.validateNotInPast("Enter desired date of flight (d/m/yyyy HH:mm): ", "Entered date/time is in the past.", false);
        Flight selectedFlight = flightDAO.chooseFitFlight(departureLocation, arrivalLocation, desiredDate);
        if (selectedFlight == null) {
            System.out.println("Reservation process aborted.");
            return;
        }
        
        String passengerName = Tool.validateAlphanumericString("Enter your name: ", "Invalid name. Please use alphanumeric characters.", false);
        String passengerContactInfo = passengerDAO.getPassengerContactInfo();
        Passenger passenger = new Passenger(passengerName, passengerContactInfo);
        passengerDAO.save(passenger);
        reservationDAO.save(new Reservation(passenger, selectedFlight));
    }
    
    

    // Other methods related to reservations and bookings
}

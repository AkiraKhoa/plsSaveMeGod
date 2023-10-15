package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;


public class Flight {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int seatNumber;
    private Set<Integer> reservedSeats = new HashSet<>();

    public Flight(String flightNumber, String departureCity, String destinationCity, 
                  LocalDateTime departureTime, LocalDateTime arrivalTime, int seatNumber) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatNumber = seatNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    
    public String toStringShowAll() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
        String formattedDepartureTime = departureTime.format(formatter);
        String formattedArrivalTime = arrivalTime.format(formatter);

        return String.format("| %-10s | %-10s | %-10s | %-20s | %-20s | %-8d |",
                             flightNumber,
                             departureCity,
                             destinationCity,
                             formattedDepartureTime,
                             formattedArrivalTime,
                             seatNumber);
    }
    
    public boolean isSeatTaken(int seatNumber) {
        return reservedSeats.contains(seatNumber);
    }

    public void reserveSeat(int seatNumber) {
        reservedSeats.add(seatNumber);
    }
    



}
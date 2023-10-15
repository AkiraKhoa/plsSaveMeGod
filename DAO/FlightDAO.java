package DAO;

import entities.Flight;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utilities.Tool;

public class FlightDAO {
    private HashMap<String, Flight> flights; 

    public FlightDAO() {
        this.flights = new HashMap<>();
    }

    public Flight getFlight(String flightNumber) {
        return flights.get(flightNumber);
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
    }
    
    public boolean exists(String flightNumber) {
        boolean check = true;
        if (flights.containsKey(flightNumber)) {
            System.out.println("Flight with ID: " + flightNumber + " already exists!");
            check = false;
        }
        return check;
    }
    
    /**
     * Searches for flights based on the given parameters: departure location, arrival location, and desired date.
     *
     * @param departureLocation - the departure city or location
     * @param arrivalLocation   - the arrival city or location
     * @param desiredDate       - the desired date of the flight
     * @return a list of flights matching the search criteria
     */
    public List<Flight> searchFlights(String departureLocation, String arrivalLocation, LocalDateTime desiredDate) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights.values()) {
            if (flight.getDepartureCity().equalsIgnoreCase(departureLocation) &&
                flight.getDestinationCity().equalsIgnoreCase(arrivalLocation) &&
                flight.getDepartureTime().toLocalDate().equals(desiredDate)) {
                matchingFlights.add(flight);
            }
        }
        if(matchingFlights.isEmpty()) {
            System.out.println("Sorry, no flights match your criteria.");
        }

        return matchingFlights;
    }
    
    

    
    public Flight chooseFitFlight(String departureLocation, String arrivalLocation, LocalDateTime desiredDates){
        List<Flight> matchingFlights = searchFlights(departureLocation, arrivalLocation, desiredDates);
        if (matchingFlights.isEmpty()) {
            System.out.println("No matching flights found.");
            return null;
        }
        while (true){
           int choice = Tool.validateIntRange("Select a flight by its number: ", 1, matchingFlights.size(), "Invalid choice. Please select a number from the displayed list.", false); 
           Flight selectedFlight = matchingFlights.get(choice - 1); 
           if (selectedFlight.getSeatNumber() <= 0) {
            System.out.println("Unfortunately, the selected flight is fully booked.");
            if (!Tool.validateYesOrNo("would you like to choose another flight(y/n): ")) {
                System.out.println("Failed to choose flights");
                return null;
            }
            else {
                matchingFlights.remove(selectedFlight);
                continue;
            }
        }
            selectedFlight.setSeatNumber(selectedFlight.getSeatNumber() - 1);
            System.out.println("You've selected flight number: " + selectedFlight.getFlightNumber());
            return selectedFlight;
        }
    }

    public void save(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
        System.out.println("Flight added successfully!");    
    }

    public void displaySeats(Flight flight) {
    // Constants for the seating
    final int SEATS_PER_ROW = 6;
    final int SEATS_BEFORE_AISLE = 3;
    
    int totalSeats = flight.getSeatNumber();
    int numRows = (int) Math.ceil((double) totalSeats / SEATS_PER_ROW);
    int exitRow = numRows / 2;
    
    int seatCounter = 1;  // Counter to track the current seat number

    for (int row = 1; row <= numRows; row++) {
        if (row == exitRow) {
            System.out.println("EXIT\t\t\t\t\t\tEXIT");
        }
        
        // Display the seat row
        for (int seat = 1; seat <= SEATS_PER_ROW; seat++) {
            if (seat == SEATS_BEFORE_AISLE + 1) {
                System.out.print("\t"); // space for the aisle
            }

            if (flight.isSeatTaken(seatCounter)) {
                System.out.printf("|  X  |");
            } else {
                System.out.printf("| %3d |", seatCounter);
                seatCounter++;
            }
        }
        System.out.println(); 
        
        // Only display the row separator for non-last rows
        if (row != numRows) {
            System.out.println("+-----++-----++-----+\t+-----++-----++-----+");
        }
    }
}
}

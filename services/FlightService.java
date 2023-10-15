package services;  
import DAO.FlightDAO;
import DAO.PassengerDAO;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import utilities.Tool;

public class FlightService {
    private FlightDAO flightDAO;
    private PassengerDAO passengerDAO;

    public FlightService() {
    }

    

    public void addFlight() {
        while (true){
            System.out.println("Enter Flight Details: ");
            String flightNumber;
            flightNumber = Tool.validateCode("Flight Number: ", "Flight number just contain AlphanumericString", false);
            if (!flightDAO.exists(flightNumber)) {
                if(Tool.validateYesOrNo("Would you like to add another products?")) continue;
                break;
            }
            String departureCity =  Tool.validateAlphanumericString("Departure City:", "nuh uh that not the name of the city", false);
            String destinationCity = Tool.validateAlphanumericString("Departure City: ", "nuh uh that not the name of the city", false);
            LocalDateTime departureTime = Tool.validateNotInPast("Departure Time (d/m/yyyy HH:mm): ", "Departure Time can't in the past", false);
            LocalDateTime arrivalTime = Tool.validateDateAfter("Arrival Time (d/m/yyyy HH:mm): ", departureTime, "Arrival Time must after Departure Time", false);
            int seatNumber = Tool.validateIntRange("Number of seat: ", 1, 120, "can only handle 120 seat", false);
            flightDAO.save(new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, seatNumber));
            if (!Tool.validateYesOrNo("Would you like to add more products?")) {
                break;
            }
        }
    }
    
    
    
    
    

//    public void listAllFlights() {
//        ConsoleUtil.println("List of All Flights:");
//        for (Flight flight : flightDAO.findAll()) {
//            ConsoleUtil.println(flight.toString());
//        }
//    }
//}
//
//    public Flight getFlight(String flightNumber) {
//        return flightDAO.getFlight(flightNumber);
//    }

    // Other methods related to flight operations
}

package factories;

import entities.Flight;
import java.time.LocalDateTime;


public class FlightFactory {
    public Flight createFlight(String flightNumber, String departureCity, 
                               String destinationCity, LocalDateTime departureTime, 
                               LocalDateTime arrivalTime, int availableSeats) {
        // Here you can include additional logic for validation if needed
        return new Flight(flightNumber, departureCity, destinationCity, 
                          departureTime, arrivalTime, availableSeats);
    }
}

package factories;
import entities.Passenger;


public class PassengerFactory {
     public Passenger createFlight(String name, String contactDetails, String reservationId) {
        // Here you can include additional logic for validation if needed
        return new Passenger(name, contactDetails, reservationId);
    }
}

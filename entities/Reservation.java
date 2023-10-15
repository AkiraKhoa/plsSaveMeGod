package entities;


public class Reservation {
    private String reservationId;
    private Passenger passenger;
    private Flight flight;
    private static int counter = 0;

    public Reservation(Passenger passenger, Flight flight) {
        this.reservationId = "R" + String.format("%06d", ++counter);
        this.passenger = passenger;
        this.flight = flight;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    
}

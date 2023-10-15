package entities;


public class Passenger {
    private String name;
    private String contactDetails;
    private String reservationId;

    public Passenger(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }
    
    public Passenger(String name, String contactDetails, String reservationId) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.reservationId = reservationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    
    
}

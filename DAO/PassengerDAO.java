package DAO;

import entities.Passenger;
import java.util.HashMap;
import utilities.Tool;

public class PassengerDAO {
    private HashMap<String, Passenger> passengers;  // contactInfo, Passenger>

    public PassengerDAO() {
        this.passengers = new HashMap<>();
    }

    public Passenger getPassenger(String reservationId) {
        return passengers.get(reservationId);
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getReservationId(), passenger);
    }

    public void save(Passenger passenger) {
        if (passenger == null) {
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        passengers.put(passenger.getContactDetails(), passenger);
        System.out.println("Passenger saved successfully!");
    }
    
    
    //ĐỂ TẠM, MỐT CHUYỂN NẾU NGẦU
    public String getPassengerContactInfo(){
        String contactInfo;
        int choice = Tool.validateIntRange("choose contact info (0 for phone number, 1 for email): ", 0, 1, "out of range, please choose between 0 and 1", false);
        while (true) {
            if (choice == 0) contactInfo = Tool.validatePhoneNumber("please enter your number: ", "exceed 9 to 13 number or invalid format", false);
            else contactInfo = Tool.validateEmail("please enter your email", "invalid format for email", false);
            if (!existPhoneNumber(contactInfo)|| !existEmail(contactInfo)) break;
        }
        return contactInfo;
    }
    
    public boolean existPhoneNumber(String phoneNumber) {
        for (Passenger passenger : passengers.values()) {
            if (passenger.getContactDetails().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
    

    public boolean existEmail(String email) {
        for (Passenger passenger : passengers.values()) {
            if (passenger.getContactDetails().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}

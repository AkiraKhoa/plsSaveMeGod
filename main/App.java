package main;
import services.AdminService;
import services.CheckInService;
import services.CrewService;
import services.FlightService;
import services.ReservationService;
import utilities.Tool;

public class App {

    // Assuming we have initialized our DAO and Service layers
    private static FlightService flightService;
    private static ReservationService reservationService;
    private static CheckInService checkInService;
    private static AdminService adminService;
    private static CrewService crewService;
   // private static DataService dataService;

    public static void main(String[] args) {
        initializeServices();

        boolean continueRunning = true;
        while (continueRunning) {
            displayMenu();

            int choice = Tool.readInt();

            switch (choice) {
                case 1:
                    // Flight schedule management
                    break;
                case 2:
                    // Passenger reservation and booking
                    break;
                case 3:
                    // Passenger check-in and seat allocation
                    break;
                case 4:
                    // Crew management and admin access
                    break;
                case 5:
                    // Save to file
                    break;
                case 6:
                    // Load and display data from file
                    break;
                case 7:
                    // Quit the application
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Flight Management System. Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("Flight Management System");
        System.out.println("1. Flight schedule management");
        System.out.println("2. Passenger reservation and booking");
        System.out.println("3. Passenger check-in and seat allocation");
        System.out.println("4. Crew management and admin access");
        System.out.println("5. Save to file");
        System.out.println("6. Load and display data from file");
        System.out.println("7. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void initializeServices() {
        // Here, instantiate DAOs and then use them to instantiate Service objects.
        // For instance:
        // FlightDAO flightDAO = new FlightDAOImpl();
        // flightService = new FlightService(flightDAO);
        // Similarly, for other DAOs and Services
    }
}

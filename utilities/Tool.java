package utilities;

import DAO.PassengerDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tool {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        int value = scanner.nextInt();
        scanner.nextLine();  
        return value;
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }
    
    public static String validateCode(String prompt, String errorMessage, boolean allowEmpty) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty() && allowEmpty) return null;
            else if (Pattern.matches("[a-zA-Z0-9]+", input)) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
    
    public static String validateAlphanumericString(String prompt, String errorMessage, boolean allowEmpty) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.isEmpty() && allowEmpty) {
                return null;
            } else if (!input.isEmpty() && Pattern.matches("[a-zA-Z0-9 ]+", input)) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
    
    public static LocalDateTime validateLocalDate(String prompt, String errorMessage, boolean allowEmpty) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:m");
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty() && allowEmpty) {
                return null;
            }

            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
            }
        }
    }
    
    
    public static LocalDateTime validateNotInPast(String prompt, String errorMessage, boolean allowEmpty) {
        LocalDateTime time;
        while (true) {
            time = validateLocalDate(prompt, "Invalid date format. Please enter again.", allowEmpty);
            if (time == null ||  time.isAfter(LocalDateTime.now())) {
                return time;
            }
            System.out.println(errorMessage);
        }
    }
    
    public static LocalDateTime validateDateAfter(String prompt, LocalDateTime afterThisDateTime, String errorMessage, boolean allowEmpty) {
        LocalDateTime time;
        while (true) {
            time = validateLocalDate(prompt, "Invalid date-time format. Please enter again.", allowEmpty);
            if (time == null || time.isAfter(afterThisDateTime)) {
                return time;
            }
            System.out.println(errorMessage);
        }
    }
    
    public static Integer validateInt(String prompt, String errorMessage, boolean allowEmpty) {
        int number;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty() && allowEmpty) return null;
            else try {
                number = Integer.parseInt(input);
                if (number > 0) {
                    break;
                } else {
                    System.out.println("It should be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
        return number;
    }
    
    public static boolean validateYesOrNo(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (y/n): ");
            input = scanner.nextLine().trim().toLowerCase();
            if ("y".equals(input) || "n".equals(input)) {
                break;
            }
            System.out.println("Invalid input. Enter 'y' for yes and 'n' for no.");
        }
        return "y".equals(input);
    }
    
    public static Integer validateIntRange(String prompt, int min, int max, String errorMessage, boolean allowEmpty) {
        int input;
        while (true) {
            System.out.print(prompt);
            String input1 = scanner.nextLine().trim();
            if (input1.isEmpty() && allowEmpty) return null;
            try {
                input = Integer.parseInt(input1);
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    
    public static String validateEmail(String prompt, String errorMessage, boolean allowEmpty) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            
            if (input.isEmpty() && allowEmpty) {
                return null;
            } else if (!input.isEmpty() && (Pattern.matches("^[A-Za-z0-9._]+@gmail.com$", input) || Pattern.matches("^[A-Za-z0-9._]+@fpt.edu.vn$", input))) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
    
    public static String validatePhoneNumber(String prompt, String errorMessage, boolean allowEmpty) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.isEmpty() && allowEmpty) {
                return null;
            } 
            if (!input.isEmpty() && Pattern.matches("^[0-9]{9,13}$", input)) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
    
    public static String validateReservationID(String prompt, String errorMessage){
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty() && Pattern.matches("R[0-9]{6}", input)) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
}
    

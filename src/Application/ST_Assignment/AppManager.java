package ST_Assignment;

import java.util.*;
import java.sql.*;

public class AppManager {
    private int userID;
    private String username;
    private String phoneNum;
    private String password;
    private String email;
    private String fullName;
    private String role;
    private Scanner scanner = new Scanner(System.in);
    private Connection connection;
    User user = new User();

    public static void main(String[] args) {
        AppManager landing = new AppManager();
        landing.welcomePage();
    }

    public AppManager() {
        initializeConnection();
    }

    public void welcomePage() {
        System.out.println("\n@=================================@");
        System.out.println("| Welcome to Hotel Booking System |");
        System.out.println("|=================================|");
        System.out.println("|          1. Log in              |");
        System.out.println("|          2. Sign up             |");
        System.out.println("|          3. Exit                |");
        System.out.println("@=================================@");
        int choice;
        try {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    user.loginPhase();
                    break;
                case 2:
                    user.signUpPhase();
                    break;
                case 3:
                    goodbyeMessage();
                    break;
                default:
                    System.out.println("\n╔══════════════════════════════════════════╗");
                    System.out.println("║     Error Message: Invalid Selection     ║");
                    System.out.println("╚══════════════════════════════════════════╝");
                    System.out.println("Please try again ...");
                    System.out.println("");
                    welcomePage();
            }
        } catch (InputMismatchException e) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║    Error Message: Invalid Input Format   ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.println("Please enter a valid integer choice (1-3) ...");
            System.out.println("");
            scanner.nextLine();
            welcomePage();
        }
    }

    public void goodbyeMessage() {

        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║                            ║");
        System.out.println("║   Goodbye! Have a nice     ║");
        System.out.println("║            day!            ║");
        System.out.println("║                            ║");
        System.out.println("╚════════════════════════════╝");
    }

    // Menu
    public void displayMenu() {
        
        System.out.println("\n@====================================@");
        System.out.println("|         << CUSTOMER MENU >>        |");
        System.out.println("|====================================|");
        System.out.println("|  1. Check Room                     |");
        System.out.println("|  2. Manage Booking                 |");
        System.out.println("|  3. Waiting List                   |");
        System.out.println("|  4. Quit                           |");
        System.out.println("@====================================@");
        
        try {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            processChoice(choice);
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║    Error Message: Invalid Input Format   ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.println("Please try again ...\n");
            scanner.nextLine();
            displayMenu();
        }
    }

    public void processChoice(int choice) {
    	
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("");
                System.out.println("\n╔══════════════════════════════════════════╗");
                System.out.println("║     Error Message: Invalid Selection     ║");
                System.out.println("╚══════════════════════════════════════════╝");
                System.out.println("Please try again ...\n");
                displayMenu();
        }

    }

    // Establish connection
    public void initializeConnection() {
        try {
            connection = dbConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getUserID(String username) {
        String query = "SELECT userID FROM user_account WHERE username = ? ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                userID = resultSet.getInt("userID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userID;
    }

    

}

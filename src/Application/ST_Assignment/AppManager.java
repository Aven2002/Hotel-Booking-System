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
                    loginPhase();
                    break;
                case 2:
                    signUpPhase();
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

    // Login
    public void loginPhase() {
        System.out.println("\n+=============================+");
        System.out.println("║           Login             ║ ");
        System.out.println("+=============================+");
        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        String query = "SELECT role FROM user_account WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                System.out.println("\nLogin successful.............\n");
                displayMenu(role);
            } else {
                System.out.println("\n╔══════════════════════════════════╗");
                System.out.println("║   Invalid username or password   ║");
                System.out.println("║ Please try again with valid      ║");
                System.out.println("║            credentials           ║");
                System.out.println("╚══════════════════════════════════╝");
                System.out.println("Please try again.............");
                welcomePage();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sign Up
    public void signUpPhase() {

        try {
            System.out.println("\n+-----------------------------+");
            System.out.println("|   Account Registration      |");
            System.out.println("+-----------------------------+");
            
            System.out.print("Enter your full name (e.g., MACC DING): ");
        	fullName = scanner.nextLine();
            if (!isValidFullName(fullName)) {
                System.out.println("\n╔══════════════════════════════════════════════╗");
                System.out.println("║     Error Message: Invalid full name format  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("Please try again ...\n");
                welcomePage();
            }

            System.out.print("Enter your phone number (e.g., 0102223333): ");
            phoneNum = scanner.nextLine();
            if (!isValidPhoneNumber(phoneNum)) {
                System.out.println("\n╔═════════════════════════════════════════════════╗");
                System.out.println("║      Error Message: Invalid phone number        ║");
                System.out.println("║                                                 ║");
                System.out.println("║  Contact number must consist 10 to 15 digits.   ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
                System.out.println("Please try again ...\n");
                welcomePage();
            }

            System.out.print("Enter your email address (e.g., maccding@outlook.com): ");
            email = scanner.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("\n╔══════════════════════════════════════════════════╗");
                System.out.println("║  Error Message: Invalid email addrerss format    ║");
                System.out.println("║                                                  ║");
                System.out.println("║  Email address must follow the standard format   ║");
                System.out.println("╚══════════════════════════════════════════════════╝");
                System.out.println("Please try again ...\n");
                welcomePage();
            }

            System.out.print("Enter your username (e.g., macc2020): ");
            username = scanner.nextLine();
            if (!isValidUsername(username)) {
                System.out.println(
                        "\n╔════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.println(
                        "║                       Error Message:  Invalid username format                      ║");
                System.out.println(
                        "║                                                                                    ║");
                System.out.println(
                        "║  Username must consist of alphanumeric characters and have at least 5 characters.  ║");
                System.out.println(
                        "╚════════════════════════════════════════════════════════════════════════════════════╝");

                System.out.println("Please try again ...\n");
                welcomePage();
            }

            System.out.print("Enter your password: ");
            password = scanner.nextLine();

            String query = "INSERT INTO user_account (role, username, fullName, password, contactNum, email) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, role);
                statement.setString(2, username);
                statement.setString(3, fullName);
                statement.setString(4, password);
                statement.setString(5, phoneNum);
                statement.setString(6, email);

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("\n╔══════════════════════════════════════════════╗");
                    System.out.println("║          Confirmation Message:               ║");
                    System.out.println("║                                              ║");
                    System.out.println("║        Account Successfully Created          ║");
                    System.out.println("║ You can now log in using your credentials    ║");
                    System.out.println("╚══════════════════════════════════════════════╝");
                    loginPhase();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("\n╔══════════════════════════════════════════════╗");
                System.out.println("║     Error Message: Account Creation Failed   ║");
                System.out.println("╚══════════════════════════════════════════════╝");
                System.out.println("Please try again ...\n");
                displayMenu(role);
            }
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
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
    public void displayMenu(String role) {
        
        System.out.println("\n@====================================@");
        System.out.println("|         << CUSTOMER MENU >>        |");
        System.out.println("|====================================|");
        System.out.println("|  1. Browse Product                 |");
        System.out.println("|  2. Create Order                   |");
        System.out.println("|  3. View Billing Statement         |");
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
            displayMenu(role);
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
                displayMenu(role);
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

    public boolean isValidFullName(String fullName) {
        return fullName.matches("[A-Za-z]+(\\s[A-Za-z]+){1,}");
    }

    public boolean isValidPhoneNumber(String phoneNum) {
        return phoneNum.matches("\\d{10,15}");
    }

    public boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9]{5,}");
    }

}

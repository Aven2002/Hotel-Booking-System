package ST_Assignment;

import java.util.*;
import java.sql.*;

public class AppManager {
	
    private Scanner scanner = new Scanner(System.in);
    private Connection connection;
    private User user;

    public static void main(String[] args) {
        AppManager app = new AppManager();
        app.welcomePage();
    }

    public AppManager() {
        initializeConnection();
    }

    public void welcomePage() {
		user = new User();
		try {
			System.out.println("\n@=================================@");
            System.out.println("| Welcome to Hotel Booking System |");
            System.out.println("|=================================|");
            System.out.println("|          1. Log in              |");
            System.out.println("|          2. Sign up             |");
            System.out.println("|          3. Exit                |");
            System.out.println("@=================================@");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
            	case 1:
            		user.loginPhase();
            	case 2:
            		user.signUpPhase();
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
		}catch(InputMismatchException e) {
			System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║    Error Message: Invalid Input Format   ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.println("Please enter a valid integer choice (1-3) ...");
            System.out.println("");
            scanner.nextLine();
            welcomePage();
		}
	}
    
    public void displayMenu() {
		try {
			System.out.println("\n@====================================@");
            System.out.println("|         << CUSTOMER MENU >>        |");
            System.out.println("|====================================|");
            System.out.println("|  1. Check Room                     |");
            System.out.println("|  2. Manage Booking                 |");
            System.out.println("|  3. Waiting List                   |");
            System.out.println("|  4. Quit                           |");
            System.out.println("@====================================@");
    		
    		System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            processChoice(choice);
            
		}catch(InputMismatchException e) {
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

    public void goodbyeMessage() {

        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║                            ║");
        System.out.println("║   Goodbye! Have a nice     ║");
        System.out.println("║            day!            ║");
        System.out.println("║                            ║");
        System.out.println("╚════════════════════════════╝");
    }


    // Establish connection
    public void initializeConnection() {
        try {
            connection = dbConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

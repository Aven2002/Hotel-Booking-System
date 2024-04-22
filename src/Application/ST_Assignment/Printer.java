package ST_Assignment;

<<<<<<< HEAD
import java.util.*;

public class Printer {
private final Scanner scanner=new Scanner(System.in);
	 public static void main(String[] args) {
	        AppManager app = new AppManager();
	        app.welcomePage();
	    }
	 
	public void welcomePage() {
        System.out.println("\n@===================================@");
        System.out.println("| Welcome to Hotel Booking System   |");
        System.out.println("|===================================|");
        System.out.println("|       1. Log in                   |");
        System.out.println("|       2. Sign up                  |");
        System.out.println("|       3. Continue as guest        |");
        System.out.println("|       4. Exit                     |");
        System.out.println("@===================================@");
        int choice;
        try {
        	User user=new User();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
           // scanner.nextLine();
            switch (choice) {
    
                case 4:
                	goodbyeMessage();
                	return;
			default:
                    System.out.println("\n==========================================");
                    System.out.println("     Error Message: Invalid Selection     ");
                    System.out.println("==========================================");
                    System.out.println("Please try again ...");
            }
        } catch (InputMismatchException e) {
            System.out.println("\n==========================================");
            System.out.println("    Error Message: Invalid Input Format   ");
            System.out.println("==========================================");
            System.out.println("Please enter a valid integer choice (1-4) ...");
            scanner.nextLine();
        }
    }
	
	public void goodbyeMessage() {
        System.out.println("\n===============================");
        System.out.println("                               ");
        System.out.println("   Goodbye! Have a nice day!   ");
        System.out.println("                               ");
        System.out.println("===============================");
    }
=======
public class Printer {
	
	public void printInfo(String name, String member_type, String room_type) {
		System.out.println("\n==============================================");
        System.out.println("                   Result                     ");
        System.out.println("==============================================\n");
        System.out.println("        Name          : " + name);
        System.out.println("        Member Type   : " + member_type);
        System.out.println("        Room Type     : " + room_type);
        System.out.println("\n==============================================");

	}
>>>>>>> 2f6ee2faf8fcb4070884f16c5cf6b82764c7b177
}

//public static void printInfo(String name, String member_type, String room_type) {
//StringBuilder sb = new StringBuilder();
//sb.append("\n==============================================\n");
//sb.append("                   Result                     \n");
//sb.append("==============================================\n");
//sb.append("        Name          : ").append(name).append("\n");
//sb.append("        Member Type   : ").append(member_type).append("\n");
//sb.append("        Room Type     : ").append(room_type).append("\n");
//sb.append("\n==============================================\n");
//System.out.println(sb.toString());
//}

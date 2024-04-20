package ST_Assignment;
import java.util.*;
import java.sql.*;

public class Booking {
	private final Scanner scanner=new Scanner(System.in);
	//private final AppManager app=new AppManager();
	private Booking booking;
	private int userID;
	private int roomID;
	private int bookingID;
	private Connection connection;
	
	public static void main(String[]args) {
		Booking book=new Booking(123,456);
		book.cancelBooking();
	}
	
	public Booking(int userID,int roomID) {
		//app.initializeConnection();
		this.userID=userID;
		this.roomID=roomID;
	}
	
	public void setBooking(Booking booking) {
	
		this.booking=booking;
		
	}
	
	public void cancelBooking() {
		try {
			connection = dbConnector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print("Enter the correspond booking ID to process booking cancelation :");
		try {
		bookingID=scanner.nextInt();
		scanner.nextLine();
		}catch(InputMismatchException e) {
			scanner.nextLine();
			  System.out.println("\n============================================");
	            System.out.println("    Error Message: Invalid Input Format   ");
	            System.out.println("==========================================");
	            System.out.println("Please try again ...\n");
	            cancelBooking();
		}
		
		if (searchBooking(bookingID)) {
		    displayBooking(bookingID);
		        System.out.println("Do you want to continue the booking cancellation process? (Yes || No)");
		        String choice = scanner.nextLine();
		        if(choice.equalsIgnoreCase("Yes")) {
		                String deleteQuery = "DELETE FROM booking WHERE bookingID = ?";
		                try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
		                    statement.setInt(1, bookingID);
		                    int rowsAffected = statement.executeUpdate();
		                    if (rowsAffected > 0) {
		                        System.out.println("\n=====================================================================");
		                        System.out.println("  Confirmation Message: Booking with ID " + bookingID + " successfully cancelled.");
		                        System.out.println("=====================================================================");
		                    }
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		        	}
			} else {
				System.out.println("\n===========================================");
			    System.out.println("   Error Message: Booking ID not found   ");
			    System.out.println("===========================================");
			    System.out.println("Please try again ...\n");
			    cancelBooking();
			}
	}
	
	public boolean searchBooking(int bookingID) {
	    String searchQuery = "SELECT bookingID FROM booking WHERE bookingID = ?";
	    try (PreparedStatement statement = connection.prepareStatement(searchQuery)) {
	        statement.setInt(1, bookingID);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public void displayBooking(int bookingID) {
	    String query = "SELECT * FROM booking WHERE bookingID = ?";
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, bookingID);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                int bookedID = resultSet.getInt("bookingID");
	                int roomID = resultSet.getInt("roomID");
	                Timestamp created = resultSet.getTimestamp("created_at");

	                System.out.println("\n===========================================");
	                System.out.println("      Booking ID    : " + bookedID);
	                System.out.println("      Room ID       : " + roomID);
	                System.out.println("      Creation Date : " + created);
	                System.out.println("===========================================");
	            } else {
	            	System.out.println("\n===========================================");
	    		    System.out.println("   Error Message: Booking ID not found   ");
	    		    System.out.println("===========================================");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	


}

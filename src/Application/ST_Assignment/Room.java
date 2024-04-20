package ST_Assignment;
import java.util.*;
import java.sql.*;

public class Room {
	private Scanner scanner =new Scanner(System.in);
	private final String VIP_ROOM_QUERY = "SELECT COUNT(*) FROM room WHERE roomType = 'VIP' AND roomStatus = 'available'";
    private final String DELUXE_ROOM_QUERY = "SELECT COUNT(*) FROM room WHERE roomType = 'Deluxe' AND roomStatus = 'available'";
    private final String STANDARD_ROOM_QUERY = "SELECT COUNT(*) FROM room WHERE roomType = 'Standard' AND roomStatus = 'available'";
	
	public static void main(String[]args) {
		
	}

	
    public void checkRoom(String memberLevel) {
        try (Connection connection = dbConnector.getConnection()) {
            int availableRooms = 0;
            String query = "";
            switch (memberLevel) {
                case "VIP":
                    query = VIP_ROOM_QUERY;
                    break;
                case "member":
                    query = DELUXE_ROOM_QUERY;
                    break;
                default:
                    query = STANDARD_ROOM_QUERY;
                    break;
            }
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        availableRooms = resultSet.getInt(1);
                    }
                }
            }
            System.out.println("Available rooms for " + memberLevel + " level: " + availableRooms);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

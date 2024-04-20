package ST_Assignment;

import java.sql.*;

public class Room {
    private int vip;
    private int deluxe;
    private int standard;

    public Room() {
       checkRoom();
    }

    private void checkRoom() {
        try (Connection connection = dbConnector.getConnection()) {
            vip = fetchRoomCount(connection, "VIP");
            deluxe = fetchRoomCount(connection, "Deluxe");
            standard = fetchRoomCount(connection, "Standard");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int fetchRoomCount(Connection connection, String roomType) throws SQLException {
        String query = "SELECT COUNT(*) FROM room WHERE roomType = ? AND roomStatus = 'available'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roomType);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        return 0; 
    }

    public void displayAvailableRooms(String memberLevel) {
        switch (memberLevel) {
            case "VIP":
                System.out.println("Available VIP rooms: " + vip);
                break;
            case "member":
                System.out.println("Available Deluxe rooms: " + deluxe);
                break;
            default:
                System.out.println("Available Standard rooms: " + standard);
                break;
        }
    }

    public static void main(String[] args) {
        Room room = new Room();
        room.displayAvailableRooms("VIP");
    }
}

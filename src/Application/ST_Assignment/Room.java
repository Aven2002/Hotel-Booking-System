package ST_Assignment;

import java.sql.*;

public class Room {
    private int vip;
    private int deluxe;
    private int standard;
    private Connection connection;
    private AppManager app;

    public Room(Connection connection) {
        this.connection = connection;
        this.app = new AppManager();
        checkRoom();
    }

    public void checkRoom() {
        try {
            vip = fetchRoomCount("VIP");
            deluxe = fetchRoomCount("Deluxe");
            standard = fetchRoomCount("Standard");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int fetchRoomCount(String roomType) throws SQLException {
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

//    public static void main(String[] args) {
//        // Initialize database connection
//        try {
//            Connection connection = dbConnector.getConnection();
//            Room room = new Room(connection);
//            room.displayAvailableRooms("VIP");
//            // Close the connection when done
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
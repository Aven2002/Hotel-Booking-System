package ST_Assignment;

import java.sql.*;

public class dbConnector {
    private static String url = "jdbc:mysql://localhost:3306/sport_store_system";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
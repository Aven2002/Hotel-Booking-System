package ST_Assignment;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;

public class dbConnectorTest {

    @Test
    public void testConnection() {
        try {
            Connection conn = dbConnector.getConnection();
            assertNotNull("Connection should not be null", conn);
            assertFalse("Connection should not be closed", conn.isClosed());
            conn.close(); // Close the connection after testing
        } catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }
    }
}


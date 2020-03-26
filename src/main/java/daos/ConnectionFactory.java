package daos;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/randomDB?serverTimezone=UTC";
    public static final String USER = "testUser";
    public static final String PASS = "zipCode?6.0";
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

    /**
     * Get a connection to database
     */
    public Connection getConnection() {
        Connection c;
        try {
            DriverManager.registerDriver(new Driver());
            c= DriverManager.getConnection(URL, USER, PASS);
            LOGGER.info("Connection Successful");

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return c;
    }
    /*
     * Test Connection
     */
//    public static void main(String[] args) {
//        ConnectionFactory cf = new ConnectionFactory();
//        cf.getConnection();
//    }
}

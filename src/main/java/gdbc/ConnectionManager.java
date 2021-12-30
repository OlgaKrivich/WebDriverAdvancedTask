package gdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance = null;

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/jdbcfirst";
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "root";
    private static Connection connection;


    private ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    private boolean openConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, USER_PASSWORD);
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            if (openConnection()) {
                System.out.println("Connection opened");
                return connection;
            } else {
                return null;
            }
        }
        return connection;
    }

    public void close() {
        System.out.println("Closing connection");
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {

        }
    }
}

package  bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    public Conn() {
        try {
            // Ensure you're using the correct MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Database connection URL (update your database details here)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:330/banksystem", "root", "Shivani@123");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

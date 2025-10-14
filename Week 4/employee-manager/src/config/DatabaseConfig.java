package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConfig {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/employee_manager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";




    public  static Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    }


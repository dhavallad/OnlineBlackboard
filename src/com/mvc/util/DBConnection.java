package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// static reference to itself
	private static DBConnection instance = new DBConnection();
	public static final String URL = "jdbc:mysql://localhost:3306/TermProject";
	public static final String USER = "root";
	public static final String PASSWORD = "kuku";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// private constructor
	private DBConnection() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
            System.out.println("Driver Loaded.");
        } catch (ClassNotFoundException e) {
        	System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

	private Connection createConnection() {

		Connection connection = null;
		try {
			// Step 3: Establish Java MySQL connection
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}

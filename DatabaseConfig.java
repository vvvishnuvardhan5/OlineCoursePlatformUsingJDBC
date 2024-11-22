package com.onlinecourseplatform.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

	 static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("JDBC Driver loaded");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        String url = "jdbc:mysql://localhost:3306/online_course_platform?useSSL=false";
	        String username = "root";
	        String password = "vishnu125";
	        return DriverManager.getConnection(url, username, password);
	    }
}

package com.onlinecourseplatform;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.dao.CourseDao;
import com.onlinecourseplatform.dao.EnrollmentsDao;
import com.onlinecourseplatform.dao.UserDao;
public class Main {

	public static void main(String[] args)throws SQLException {
		 try (Connection connection = DatabaseConfig.getConnection()) {
	            if (connection != null) {
	                System.out.println("Database connection established.");
	            }

	            UserDao userDao = new UserDao();
	            CourseDao courseDao = new CourseDao();
	            EnrollmentsDao enrollmentsDao = new EnrollmentsDao();
	            Scanner scanner = new Scanner(System.in);

	            while (true) {
	                System.out.println("\nMain Menu:");
	                System.out.println("1. User Operations");
	                System.out.println("2. Course Operations");
	                System.out.println("3. Enrollment Operations");
	                System.out.println("4. Exit");

	                int choice = scanner.nextInt();
	                scanner.nextLine();

	                switch (choice) {
	                    case 1:
	                        userDao.performOperations();
	                        break;
	                    case 2:
	                        courseDao.performCourseOperations();
	                        break;
	                    case 3:
	                    	 enrollmentsDao.performOperations();
	                         break;
	                         
	                    case 4:
	                        System.out.println("Exiting...");
	                        scanner.close();
	                        return;     
	                         
	                    
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 }


	
	
	
	


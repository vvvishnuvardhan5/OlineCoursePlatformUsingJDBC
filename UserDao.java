package com.onlinecourseplatform.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.User;


public class UserDao {
	  // Users CRUD operations related code

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO Users (user_id, username, email, password, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            // Use values from the provided user object
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());

            // Execute the SQL statement
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Insertion successful");
            } else {
                System.out.println("Insertion failed");
            }
        }
    }

    public void getAllUsers() throws SQLException {
        String query = "SELECT * FROM Users";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("user_id") + ", Username: " + rs.getString("username")+",Email Id : "+rs.getString("Email")+",Role:"+rs.getString("Role"));
            }
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM Users WHERE user_id = ?";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Deletion successful for user ID: " + userId);
            } else {
                System.out.println("User with ID " + userId + " not found.");
            }
        }
    }
    
    
    public void updateUser(int userId, String newUsername, String newEmail, String newPassword, String newRole) throws SQLException {
        String query = "UPDATE Users SET username = ?, email = ?, password = ?, role = ? WHERE user_id = ?";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, newUsername);
            ps.setString(2, newEmail);
            ps.setString(3, newPassword);
            ps.setString(4, newRole);
            ps.setInt(5, userId);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Update successful for user ID: " + userId);
            } else {
                System.out.println("User with ID " + userId + " not found.");
            }
        }
    }

    
    
    
    
    
    
    public void performOperations() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();

        while (true) {
        	System.out.println("\nChoose an operation:");
            System.out.println("1. Add User");
            System.out.println("2. Get All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                       
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter Role: ");
                        String role = scanner.nextLine();

                        User user = new User(userId, username, email, password, role);
                        userDao.addUser(user);
                        break;

                    case 2:
                        // Retrieve and display all users
                        userDao.getAllUsers();
                        break;

                        
                    case 3:
                        System.out.print("Enter User ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter new Email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new Password: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Enter new Role: ");
                        String newRole = scanner.nextLine();

                        userDao.updateUser(updateId, newUsername, newEmail, newPassword, newRole);
                        break;

                    case 4:
                        System.out.print("Enter User ID to delete: ");
                        int deleteId = scanner.nextInt();
                        userDao.deleteUser(deleteId);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

              

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
	        
}

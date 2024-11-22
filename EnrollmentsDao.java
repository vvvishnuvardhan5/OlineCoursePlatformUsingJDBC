package com.onlinecourseplatform.dao;


import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.Enrollment;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.Enrollment;

public class EnrollmentsDao {

	
	// Enrollments CRUD operations

    public void addEnrollment(Enrollment enrollment) throws SQLException {
        String query = "INSERT INTO Enrollments (enrollment_id, user_id, course_id, enrollment_date) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, enrollment.getEnrollmentId());
            ps.setInt(2, enrollment.getUserId());
            ps.setInt(3, enrollment.getCourseId());
            ps.setDate(4, enrollment.getEnrollmentDate());

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Enrollment successful");
            } else {
                System.out.println("Enrollment failed");
            }
        }
    }

    public void getAllEnrollments() throws SQLException {
        String query = "SELECT * FROM Enrollments";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Enrollment ID: " + rs.getInt("enrollment_id") +
                                   ", User ID: " + rs.getInt("user_id") +
                                   ", Course ID: " + rs.getInt("course_id") +
                                   ", Enrollment Date: " + rs.getDate("enrollment_date"));
            }
        }
    }

    public void deleteEnrollment(int enrollmentId) throws SQLException {
        String query = "DELETE FROM Enrollments WHERE enrollment_id = ?";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, enrollmentId);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Deletion successful for enrollment ID: " + enrollmentId);
            } else {
                System.out.println("Enrollment with ID " + enrollmentId + " not found.");
            }
        }
    }

    public void updateEnrollment(int enrollmentId, int newUserId, int newCourseId, java.sql.Date newEnrollmentDate) throws SQLException {
        String query = "UPDATE Enrollments SET user_id = ?, course_id = ?, enrollment_date = ? WHERE enrollment_id = ?";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, newUserId);
            ps.setInt(2, newCourseId);
            ps.setDate(3, newEnrollmentDate);
            ps.setInt(4, enrollmentId);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Update successful for enrollment ID: " + enrollmentId);
            } else {
                System.out.println("Enrollment with ID " + enrollmentId + " not found.");
            }
        }
    }

    public void performOperations() {
        Scanner scanner = new Scanner(System.in);
        EnrollmentsDao enrollmentsDao = new EnrollmentsDao();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Enrollment");
            System.out.println("2. Get All Enrollments");
            System.out.println("3. Update Enrollment");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Enrollment ID: ");
                        int enrollmentId = scanner.nextInt();
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        System.out.print("Enter Course ID: ");
                        int courseId = scanner.nextInt();
                        System.out.print("Enter Enrollment Date (yyyy-mm-dd): ");
                        java.sql.Date enrollmentDate = java.sql.Date.valueOf(scanner.next());

                        Enrollment enrollment = new Enrollment(enrollmentId, userId, courseId, enrollmentDate);
                        enrollmentsDao.addEnrollment(enrollment);
                        break;

                    case 2:
                        enrollmentsDao.getAllEnrollments();
                        break;

                    case 3:
                        System.out.print("Enter Enrollment ID to update: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter new User ID: ");
                        int newUserId = scanner.nextInt();
                        System.out.print("Enter new Course ID: ");
                        int newCourseId = scanner.nextInt();
                        System.out.print("Enter new Enrollment Date (yyyy-mm-dd): ");
                        java.sql.Date newEnrollmentDate = java.sql.Date.valueOf(scanner.next());

                        enrollmentsDao.updateEnrollment(updateId, newUserId, newCourseId, newEnrollmentDate);
                        break;

                    case 4:
                        System.out.print("Enter Enrollment ID to delete: ");
                        int deleteId = scanner.nextInt();
                        enrollmentsDao.deleteEnrollment(deleteId);
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

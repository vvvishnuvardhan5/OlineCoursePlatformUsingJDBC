package com.onlinecourseplatform.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.Scanner;

import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.Course;

public class CourseDao {

	public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO Courses (course_id, course_name, description, instructor_id, category, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getDescription());
            ps.setInt(4, course.getInstructorId());
            ps.setString(5, course.getCategory());
            ps.setBigDecimal(6, course.getPrice());

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Course added successfully.");
            } else {
                System.out.println("Failed to add course.");
            }
        }
    }

    public void getAllCourses() throws SQLException {
        String query = "SELECT * FROM Courses";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("course_id") + 
                                   ", Name: " + rs.getString("course_name") + 
                                   ", Description: " + rs.getString("description") + 
                                   ", Instructor ID: " + rs.getInt("instructor_id") + 
                                   ", Category: " + rs.getString("category") + 
                                   ", Price: " + rs.getBigDecimal("price"));
            }
        }
    }

    public void updateCourse(int courseId, String newName, String newDescription, int newInstructorId, String newCategory, BigDecimal newPrice) throws SQLException {
        String query = "UPDATE Courses SET course_name = ?, description = ?, instructor_id = ?, category = ?, price = ? WHERE course_id = ?";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, newName);
            ps.setString(2, newDescription);
            ps.setInt(3, newInstructorId);
            ps.setString(4, newCategory);
            ps.setBigDecimal(5, newPrice);
            ps.setInt(6, courseId);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Failed to update course.");
            }
        }
    }

    public void deleteCourse(int courseId) throws SQLException {
        String query = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, courseId);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Course deleted successfully.");
            } else {
                System.out.println("Failed to delete course. Course ID not found.");
            }
        }
    }

    public void performCourseOperations() {
        Scanner scanner = new Scanner(System.in);
        CourseDao courseDao = new CourseDao();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Course");
            System.out.println("2. Get All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Course ID: ");
                        int courseId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter Instructor ID: ");
                        int instructorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        BigDecimal price = scanner.nextBigDecimal();

                        Course course = new Course(courseId, courseName, description, instructorId, category, price);
                        courseDao.addCourse(course);
                        break;

                    case 2:
                        courseDao.getAllCourses();
                        break;

                    case 3:
                        System.out.print("Enter Course ID to update: ");
                        int updateCourseId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Course Name: ");
                        String newCourseName = scanner.nextLine();
                        System.out.print("Enter new Description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new Instructor ID: ");
                        int newInstructorId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Category: ");
                        String newCategory = scanner.nextLine();
                        System.out.print("Enter new Price: ");
                        BigDecimal newPrice = scanner.nextBigDecimal();

                        courseDao.updateCourse(updateCourseId, newCourseName, newDescription, newInstructorId, newCategory, newPrice);
                        break;

                    case 4:
                        System.out.print("Enter Course ID to delete: ");
                        int deleteCourseId = scanner.nextInt();
                        courseDao.deleteCourse(deleteCourseId);
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

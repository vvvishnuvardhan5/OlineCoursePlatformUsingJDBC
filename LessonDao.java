package com.onlinecourseplatform.dao;
import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LessonDao {

	
	public void addLesson(Lesson lesson) throws SQLException {
        String query = "INSERT INTO Lessons (course_id, title, content, `order`) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, lesson.getCourseId());
            ps.setString(2, lesson.getTitle());
            ps.setString(3, lesson.getContent());
            ps.setInt(4, lesson.getOrder());
            ps.executeUpdate();
        }
    }

    public void getAllLessons() throws SQLException {
        String query = "SELECT * FROM Lessons";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Lesson ID: " + rs.getInt("lesson_id") + ", Title: " + rs.getString("title"));
            }
        }
    }
	
	
}

package com.onlinecourseplatform.dao;

import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.Quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizDao {

	public void addQuiz(Quiz quiz) throws SQLException {
        String query = "INSERT INTO Quizzes (course_id, due_date) VALUES (?, ?)";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, quiz.getCourseId());
            ps.setDate(2, (Date) quiz.getDueDate());
            ps.executeUpdate();
        }
    }

    public void getAllQuizzes() throws SQLException {
        String query = "SELECT * FROM Quizzes";
        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Quiz ID: " + rs.getInt("quiz_id") + ", Course ID: " + rs.getInt("course_id"));
            }
        }
    }

	
	
	
	
}

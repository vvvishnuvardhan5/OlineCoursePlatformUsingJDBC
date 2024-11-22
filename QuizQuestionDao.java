package com.onlinecourseplatform.dao;


import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.QuizQuestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizQuestionDao {

	  public void addQuizQuestion(QuizQuestion question) throws SQLException {
	        String query = "INSERT INTO QuizQuestions (quiz_id, question_text, options) VALUES (?, ?, ?)";
	        try (Connection con = DatabaseConfig.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setInt(1, question.getQuizId());
	            ps.setString(2, question.getQuestionText());
	            ps.setString(3, question.getOptions());
	            ps.executeUpdate();
	        }
	    }

	    public void getAllQuizQuestions() throws SQLException {
	        String query = "SELECT * FROM QuizQuestions";
	        try (Connection con = DatabaseConfig.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                System.out.println("Question ID: " + rs.getInt("question_id") + ", Quiz ID: " + rs.getInt("quiz_id"));
	            }
	        }
	    }
	
	
}

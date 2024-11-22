package com.onlinecourseplatform.dao;

import com.onlinecourseplatform.config.DatabaseConfig;
import com.onlinecourseplatform.model.QuizSubmission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class QuizSubmissionDao {

	 public void addQuizSubmission(QuizSubmission submission) throws SQLException {
	        String query = "INSERT INTO QuizSubmissions (user_id, quiz_id, score, submitted_at) VALUES (?, ?, ?, ?)";
	        try (Connection con = DatabaseConfig.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setInt(1, submission.getUserId());
	            ps.setInt(2, submission.getQuizId());
	            ps.setInt(3, submission.getScore());
	            ps.setTime(4, (Time) submission.getSubmittedAt());
	            ps.executeUpdate();
	        }
	    }

	    public void getAllQuizSubmissions() throws SQLException {
	        String query = "SELECT * FROM QuizSubmissions";
	        try (Connection con = DatabaseConfig.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                System.out.println("Submission ID: " + rs.getInt("submission_id") + ", User ID: " + rs.getInt("user_id"));
	            }
	        }
	    }
 }
package com.onlinecourseplatform.model;


import java.util.Date;

public class QuizSubmission {

	
	 private int submissionId;
	    private int userId;
	    private int quizId;
	    private int score;
	    private Date submittedAt;

	    public QuizSubmission() {}

	    public QuizSubmission(int submissionId, int userId, int quizId, int score, Date submittedAt) {
	        this.submissionId = submissionId;
	        this.userId = userId;
	        this.quizId = quizId;
	        this.score = score;
	        this.submittedAt = submittedAt;
	    }

	    public int getSubmissionId() {
	        return submissionId;
	    }

	    public void setSubmissionId(int submissionId) {
	        this.submissionId = submissionId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public int getQuizId() {
	        return quizId;
	    }

	    public void setQuizId(int quizId) {
	        this.quizId = quizId;
	    }

	    public int getScore() {
	        return score;
	    }

	    public void setScore(int score) {
	        this.score = score;
	    }

	    public Date getSubmittedAt() {
	        return submittedAt;
	    }

	    public void setSubmittedAt(Date submittedAt) {
	        this.submittedAt = submittedAt;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

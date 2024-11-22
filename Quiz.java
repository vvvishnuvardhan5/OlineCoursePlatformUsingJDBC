package com.onlinecourseplatform.model;

import java.util.Date;


public class Quiz {

	
	
	private int quizId;
    private int courseId;
    private Date dueDate;

    public Quiz() {}

    public Quiz(int quizId, int courseId, Date dueDate) {
        this.quizId = quizId;
        this.courseId = courseId;
        this.dueDate = dueDate;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
}

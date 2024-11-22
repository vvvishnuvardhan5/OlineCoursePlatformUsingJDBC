package com.onlinecourseplatform.model;

import java.util.Date;



public class Enrollment {

	 private int enrollmentId;
	    private int userId;
	    private int courseId;
	    private java.sql.Date enrollmentDate;

	    public Enrollment() {}

	    public Enrollment(int enrollmentId, int userId, int courseId, java.sql.Date enrollmentDate) {
	        this.enrollmentId = enrollmentId;
	        this.userId = userId;
	        this.courseId = courseId;
	        this.enrollmentDate = enrollmentDate;
	    }

	    public int getEnrollmentId() {
	        return enrollmentId;
	    }

	    public void setEnrollmentId(int enrollmentId) {
	        this.enrollmentId = enrollmentId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public int getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }

	    public java.sql.Date getEnrollmentDate() {
	        return enrollmentDate;
	    }

	    public void setEnrollmentDate(java.sql.Date enrollmentDate) {
	        this.enrollmentDate = enrollmentDate;
	    }
	
}

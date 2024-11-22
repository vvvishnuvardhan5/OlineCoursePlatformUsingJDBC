package com.onlinecourseplatform.model;

import java.math.BigDecimal;

public class Course {

	  private int courseId;
	    private String courseName;
	    private String description;
	    private int instructorId;
	    private String category;
	    private BigDecimal price;

	    public Course() {}

	    public Course(int courseId, String courseName, String description, int instructorId, String category, BigDecimal price) {
	        this.courseId = courseId;
	        this.courseName = courseName;
	        this.description = description;
	        this.instructorId = instructorId;
	        this.category = category;
	        this.price = price;
	    }

	    public int getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public void setCourseName(String courseName) {
	        this.courseName = courseName;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public int getInstructorId() {
	        return instructorId;
	    }

	    public void setInstructorId(int instructorId) {
	        this.instructorId = instructorId;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }
	







}

	
	
	
	
	
	
	
	
	
	
	
	
	


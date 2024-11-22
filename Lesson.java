package com.onlinecourseplatform.model;

public class Lesson {

	
	  private int lessonId;
	    private int courseId;
	    private String title;
	    private String content;
	    private int order;

	    public Lesson() {}

	    public Lesson(int lessonId, int courseId, String title, String content, int order) {
	        this.lessonId = lessonId;
	        this.courseId = courseId;
	        this.title = title;
	        this.content = content;
	        this.order = order;
	    }

	    public int getLessonId() {
	        return lessonId;
	    }

	    public void setLessonId(int lessonId) {
	        this.lessonId = lessonId;
	    }

	    public int getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public int getOrder() {
	        return order;
	    }

	    public void setOrder(int order) {
	        this.order = order;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

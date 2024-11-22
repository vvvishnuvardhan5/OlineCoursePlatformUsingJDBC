package com.onlinecourseplatform.model;

public class QuizQuestion {

	
	private int questionId;
    private int quizId;
    private String questionText;
    private String options;

    public QuizQuestion() {}

    public QuizQuestion(int questionId, int quizId, String questionText, String options) {
        this.questionId = questionId;
        this.quizId = quizId;
        this.questionText = questionText;
        this.options = options;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
	
	
	
	
	
	
	
	
	
	
	
	
}

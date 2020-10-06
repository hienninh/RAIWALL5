package com.vti.entity;

public class Answer {
	int id;
	String content;
	Question question;
	boolean isCorrect;

	// getter && setter
	
	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getId() {
		return id;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}

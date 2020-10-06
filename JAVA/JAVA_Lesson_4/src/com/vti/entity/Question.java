package com.vti.entity;
import java.time.LocalDate;

public class Question {
	private int id;
	String content;
	CategoryQuestion category;
	TypeQuestion type;
	Account creator;
	LocalDate createDate;
	Exam[] exams;
	
	//getter && setter
	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CategoryQuestion getCategory() {
		return category;
	}
	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}
	public TypeQuestion getType() {
		return type;
	}
	public void setType(TypeQuestion type) {
		this.type = type;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public Exam[] getExams() {
		return exams;
	}
	public void setExams(Exam[] exams) {
		this.exams = exams;
	}

	
}

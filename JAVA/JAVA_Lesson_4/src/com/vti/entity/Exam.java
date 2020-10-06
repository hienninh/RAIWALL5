package com.vti.entity;

import java.time.LocalDate;

public class Exam {
	private int id;
	private String code;
	String title;
	CategoryQuestion category;
	short duration;
	Account creator;
	LocalDate createDate;
	Question[] questions;

	// getter
	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	// setter
	public void setCode(String code) {
		this.code = code;
	}
}

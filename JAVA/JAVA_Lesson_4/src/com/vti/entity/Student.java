package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private Float points;

//Create Studen: tên, hometown và có điểm học lực = 0
	public Student() {
	}

	public Student(String name, String hometown, Float points) {
		this.name = name;
		this.hometown = hometown;
		this.points = points;
	}

	public Student(String name, Float points) {
		this.name = name;
		this.points = points;
	}

//getter/setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
		
	}

}

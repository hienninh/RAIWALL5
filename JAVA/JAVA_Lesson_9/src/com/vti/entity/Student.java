package com.vti.entity;

public class Student {
	private int id;
	private String name;
	public static int counter = 0;

// create
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		counter++;
	}

//get, set
	public int getId() {
		return id;
	}
	//Method moi
		public String getIdVIP() {
			return "MSV" + id;
		}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Student.counter = counter;
	}


}

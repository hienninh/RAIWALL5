package com.vti.entity;

public class Department {
	private int id;
	private String name;

	public Department() {
	}

	public Department(int id, String name) {
		this.id = 0;
		this.name = name;
	}

	// getter
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}
}

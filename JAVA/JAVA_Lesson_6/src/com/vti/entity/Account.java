package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private LocalDate createDate;
	private Group[] groups;

// Khoi tao
	public Account() {
	}

	public Account(int id, String email, String fullName) {
		this.id = id;
		this.email = email;
		this.fullName = fullName;
	}
	
	public Account(int id, String email, String fullName, Position position,LocalDate createDate ) {
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.position = position;
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "email: " + email + "\n";
		result += "userName: " + userName + "\n";
		result += "department: " + department.getName() + "\n";
		result += "Position: " + position.name + "\n";

		return result;
	}

	// get, set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

}

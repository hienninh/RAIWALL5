package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String fisrtName;
	private String lastName;
	private String fullName = fisrtName + lastName;
	private Department department;
	private Position position;
	private LocalDate createDate;
	private Group[] groups;

	public Account() {
	}

	public Account(String userName) {
		this.userName = userName;
	}

// excerscise 1_1 va 1_2
	public Account(int id, String email, String userName, String fisrtName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
	}

	public Account(int id, String email, String userName, String fisrtName, String lastName, Position position,
			LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.createDate = LocalDate.now();
		this.position.id = position.id;
	}

	// in ra account1, account2
	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "email: " + email + "\n";
		result += "userName: " + userName + "\n";
		result += "fullName: " + fisrtName + " " + lastName + "\n";
		return result;
	}

	// getter
	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public Position getPosition() {
		return position;
	}

	public Group[] getGroups() {
		return groups;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	// setter
	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFisrtName(String fisrtName) {
	}

	public void setLastName(String lastName) {
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}

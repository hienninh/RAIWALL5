package com.vti.entity;

public class User {
	private int id;
	private String fullName;
	private String Email;
	private String Password;
	private Role role;
	

//Create
	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 24, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 24, 2020
	 * @param id
	 * @param fullName
	 * @param email
	 * @param password
	 */
	public User() {
	}

	public User(int id, String fullName, String email, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.Email = email;
		this.Password = password;
		this.role = role;
	}
//get, set

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	public Role getRole() {
		return role;
	}
	
//toString
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", Email=" + Email + ", Password=" + Password + "]";
	}
}

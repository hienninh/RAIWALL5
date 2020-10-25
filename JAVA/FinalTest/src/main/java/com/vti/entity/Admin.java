package com.vti.entity;

public class Admin extends User {
	private int ExpInYear;

//Create
	/**
	 * Constructor for class Admin.
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
	 * @param expInYear
	 */
	public Admin(int id, String fullName, String email, String password, int expInYear) {
		super(id, fullName, email, password);
		ExpInYear = expInYear;
	}
//get, set

	/**
	 * @return the expInYear
	 */
	public int getExpInYear() {
		return ExpInYear;
	}

	/**
	 * @param expInYear the expInYear to set
	 */
	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

//toString
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admin [ExpInYear=" + ExpInYear + "]";
	}
}

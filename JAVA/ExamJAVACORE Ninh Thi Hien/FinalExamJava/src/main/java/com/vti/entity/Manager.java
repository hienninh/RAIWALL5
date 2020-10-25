package com.vti.entity;

public class Manager extends User {
	private int ExpInYear;
//Create

	/**
	 * Constructor for class Manager.
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @param expInYear
	 */
	public Manager() {
	}

	public Manager(int id, String fullName, String email, String password, int expInYear) {
		super(id,  fullName,  email, password);
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
		return "Manager [ExpInYear=" + ExpInYear + "]";
	}

}

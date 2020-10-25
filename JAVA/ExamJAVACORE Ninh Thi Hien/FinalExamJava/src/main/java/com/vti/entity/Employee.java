package com.vti.entity;

public class Employee extends User{
	private int projectId;
	private String ProSkill;

	// Create
	/**
	 * Constructor for class Employee.
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @param projectId
	 * @param proSkill
	 */

	public Employee() {
	}

	public Employee(int id, String fullName, String email,String password, int projectId, String proSkill) {
		super( id,  fullName,  email, password);
		this.projectId = projectId;
		ProSkill = proSkill;
	}

// get, set
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the proSkill
	 */
	public String getProSkill() {
		return ProSkill;
	}

	/**
	 * @param proSkill the proSkill to set
	 */
	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	// toString
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [projectId=" + projectId + ", ProSkill=" + ProSkill + "]";
	}

}

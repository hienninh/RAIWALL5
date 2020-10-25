package com.vti.entity;

public class Project {
	private int projectId;
	private int teamSize;
	private int idManager;
	private int idEmployees;
	
	//Create
	/**
	 * Constructor for class Project.
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @param projectId
	 * @param teamSize
	 * @param idManager
	 * @param idEmployees
	 */
	public Project(int projectId, int teamSize, int idManager, int idEmployees) {
		super();
		this.projectId = projectId;
		this.teamSize = teamSize;
		this.idManager = idManager;
		this.idEmployees = idEmployees;
	} 
	//get, set

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
	 * @return the teamSize
	 */
	public int getTeamSize() {
		return teamSize;
	}

	/**
	 * @param teamSize the teamSize to set
	 */
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	/**
	 * @return the idManager
	 */
	public int getIdManager() {
		return idManager;
	}

	/**
	 * @param idManager the idManager to set
	 */
	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	/**
	 * @return the idEmployees
	 */
	public int getIdEmployees() {
		return idEmployees;
	}

	/**
	 * @param idEmployees the idEmployees to set
	 */
	public void setIdEmployees(int idEmployees) {
		this.idEmployees = idEmployees;
	}
	//toString
	/* 
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", teamSize=" + teamSize + ", idManager=" + idManager
				+ ", idEmployees=" + idEmployees + "]";
	}
	
}

package com.vti.entity;

public class Employee extends User {
private String	ProSkill;

//create
/**
 * Constructor for class Employee.
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
 * @param proSkill
 */
public Employee(int id, String fullName, String email, String password, String proSkill) {
	super(id, fullName, email, password);
	this.ProSkill = proSkill;
}

//get, set

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


//toString
/* 
* @see java.lang.Object#toString()
*/
@Override
public String toString() {
	return "Employee [ProSkill=" + ProSkill + "]";
}


}

package com.vti.entity;

import com.vti.utils.ScannerUtils;

public class Department {
	private int id;
	private String name;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
//Question 9

	public Department() {
		ScannerUtils scanUtil = new ScannerUtils();
		System.out.println ("Moi ban nhap vao id: ");
		this.id = scanUtil.inputInt("Ban nhap sai, moi ban nhap vao 1 so!");
		System.out.println("Moi ban nhap vao ten: ");
		this.name = scanUtil.inputString();
	}


	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "name: " + name + "\n";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Department marketingDepartment = (Department) obj; // Department marketing (NEW) thanh obj
		String Name = marketingDepartment.name; // Name : cua obj
		if (Name.equals(name)) {
			return true;
		}
		return false;
	}
	// get, set

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

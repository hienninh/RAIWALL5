package com.vti.entity;

import com.vti.Utils.ScannerUtils;

public class Position {
	private short id;
	private String name;

	public Position() {
	}

	public Position(String name) {
		this.name = name;
	}
	// Question9

	public static void Position() {
		ScannerUtils scanutil = new ScannerUtils();
		System.out.println("Moi ban nhap vao ten Position");
		String name = ScannerUtils.inputString();
	}

	// get, set
	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
		return;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
		return;
	}
	// toString
	@Override
	public String toString() {
		String result = "";
		result += "Id: " + id + "\n";
		result += "Ten phong ban: " + name + "\n";
		return result;
	}

	/**
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	
}

package com.vti.entity;


public class Position {
	private short id;
	private String name;

	public Position() {
	}

	public Position( String name) {
		this.name = name;
	}
	// Question9

	public static void Position() {
		ScannerUtils scanutil = new ScannerUtils();
		System.out.println("Moi ban nhap vao ten Position");
		String name = ScannerUtils.inputString();
	}

	// get, set
	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(short id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// toString
	@Override
	public String toString() {
		String result = "";
		result += "Id: " + id + "\n";
		result += "Ten phong ban: " + name + "\n";
		return result;
	}
}

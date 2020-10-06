package com.vti.question.InheritanceQ1;

import java.util.Scanner;

public class CongNhan extends CanBo {
	private int capBac;

// scanner
	public CongNhan() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao bac: ");
		capBac = scanner.nextInt();
	}

	public CongNhan(String fullName, int age, String gender, String address, int capBac) {
		super(fullName, age, gender, address);
		this.capBac = capBac;
	}

// toString
	@Override
	public String toString() {
		String result = super.toString();
		result += "Cap bac: " + capBac + "\n";
		return super.toString();
	}

//getter va setter
	public int getCapBac() {
		return capBac;
	}

	public void setCapBac(int capBac) {
		this.capBac = capBac;
	}
}

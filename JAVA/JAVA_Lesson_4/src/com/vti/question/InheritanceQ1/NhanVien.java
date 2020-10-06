package com.vti.question.InheritanceQ1;

import java.util.Scanner;

public class NhanVien extends CanBo {
	private String congViec;

// Scanner
	public NhanVien() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao bac: ");
		congViec = scanner.nextLine();
	}

	public NhanVien(String fullName, int age, String gender, String address, String congViec) {
		super(fullName, age, gender, address);
		this.congViec = congViec;
	}

// toString
	@Override
	public String toString() {
		String result = super.toString();
		result += "Cong Viec : " + congViec + "\n";
		return result;
	}

// getter/ setter
	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

}

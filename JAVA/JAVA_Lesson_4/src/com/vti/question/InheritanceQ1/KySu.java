package com.vti.question.InheritanceQ1;

import java.util.Scanner;

public class KySu extends CanBo {
	private String nganhDaoTao;

// Scanner
	public KySu() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao nganh dao tao: ");
		nganhDaoTao = scanner.nextLine();
	}

	public KySu(String fullName, int age, String gender, String address, String nganhDaoTao) {
		super(fullName, age, gender, address);
		this.nganhDaoTao = nganhDaoTao;
	}

	// toString
	@Override
	public String toString() {
		String result = super.toString();
		result += "Nganh Dao Tao: " + nganhDaoTao + "\n";
		return result;
	}

	// getter / setter
	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

}

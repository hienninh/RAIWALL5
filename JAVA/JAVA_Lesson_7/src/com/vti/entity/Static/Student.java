package com.vti.entity.Static;

import java.util.Scanner;

public class Student {

	private int id;
	private String name;
	public static String college;
	public static int moneyGroup = 0;
	public static int count = 0;
	// Question 1_2
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		college = "Dai hoc Bach Khoa";
		addMoney(100);
		count++;
	}

	public static void addMoney(int money) {
		moneyGroup += money;
	}
	public static void spendMoney(int money) {
			moneyGroup -= money;
	}

//	public static int spendMoney(int money) {
//		while (true) {
//			Scanner scanner = new Scanner(System.in);
//			Student.moneyGroup -= money;
//			if (money > moneyGroup) {
//				System.err.println("So tien rut phai nho hon tong tien");
//				System.out.println("Moi nhap lai!");
//			} else {
//				return moneyGroup;
//			}
//			scanner.nextLine();
//		}
//	}

	// toString
	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "Name: " + name + "\n";
		result += "College: " + college + "\n";
		return result;
	}

//get, set
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

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		college = college;
	}

	public static int getMoneyGroup() {
		return moneyGroup;
	}

	public static void setMoneyGroup(int moneyGroup) {
		Student.moneyGroup = moneyGroup;
	}

}

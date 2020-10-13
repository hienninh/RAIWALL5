package com.vti.backend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Final.FinalPrimaryStudent;
import com.vti.entity.Final.FinalSecondaryStudent;
import com.vti.entity.Static.Configs;
import com.vti.entity.Static.HinhHoc;
import com.vti.entity.Static.HinhHocException;
import com.vti.entity.Static.HinhTron;
import com.vti.entity.Static.PrimaryStudent;
import com.vti.entity.Static.SecondaryStudent;
import com.vti.entity.Static.Student;

public class Static {
	static Student[] students = new Student[3];

	// Question1
	public static void Question1() {
		students[0] = new Student(1, "Nguyen van A");
		students[1] = new Student(2, "Nguyen van B");
		students[2] = new Student(3, "Nguyen van C");

		for (int i = 0; i < 3; i++) {
			System.out.println(students[i].toString());

			Student.college = "Dai hoc Cong Nghiep";
			for (int j = 0; j < 3; j++) {
				System.out.println(students[j].toString());
			}
		}
		// Cach 2: ArrayList
	}

	// Question2
	public static void Question2() {
		// nop quy 100
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Nguyen Van A"));
		students.add(new Student(2, "Nguyen Van B"));
		students.add(new Student(3, "Nguyen Van C"));

		// student1 lay 50, student2 lay ra 20, student3 lay ra 150
		System.out.println(Student.getMoneyGroup());

		students.get(0).spendMoney(50);
		System.out.println("So tien con lai la: " + Student.getMoneyGroup());
		students.get(1).spendMoney(20);
		System.out.println("So tien con lai la: " + Student.getMoneyGroup());
		students.get(2).spendMoney(150);
		System.out.println("So tien con lai la: " + Student.getMoneyGroup());
		Student.addMoney(100);
		System.out.println("So tien con lai la: " + Student.getMoneyGroup());

	}

	// Question 5: count student them vao
	public static void Question5() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Nguyen Van A"));
		students.add(new Student(2, "Nguyen Van B"));
		System.out.println(Student.count);
		students.add(new Student(3, "Nguyen Van B"));
		students.add(new Student(6, "Nguyen Van BD"));
		System.out.println(Student.count);
	}

	// Question 6
	public static void Question6() throws Exception {
		Scanner scanner = new Scanner(System.in);
		Student student1 = new PrimaryStudent(1, "Nguyen Thi A");
		Student student2 = new PrimaryStudent(2, "Nguyen Thi B");
		System.out.println("So PrimaryStudent duoc them vao : " + PrimaryStudent.counterPrimary);
		Student student3 = new SecondaryStudent(3, "Nguyen Thi C");
		Student student4 = new SecondaryStudent(4, "Nguyen Thi D");
		Student student5 = new SecondaryStudent(5, "Nguyen Thi E");
		Student student6 = new SecondaryStudent(6, "Nguyen Thi F");
		System.out.println("So SecondaryStudent duoc them vao : " + SecondaryStudent.counterSecondary);
		System.out.println("Tong so hoc sinh duoc them vao la: " + Student.count);
// Question 7: them dk de tao toi da 7 hoc sinh
		while (true) {
			if (Student.count < 7) {
				Student student7 = new SecondaryStudent(7, "Nguyen Thi F");
				System.out.println("Them moi thanh cong!, tong so hoc sinh: " + Student.count);
			} else {
				System.err.println("Chi tao toi da duoc 7 hoc sinh");
			}
			scanner.nextLine();
		}
	}

	// Question 8:
	public static void Question8() throws HinhHocException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				HinhHoc hinh1 = new HinhTron();
				if (HinhHoc.counter > Configs.soLuongHinhToiDa) {
					throw new HinhHocException("Ban chi duoc them toi da: " + Configs.soLuongHinhToiDa);
				}
			} catch (HinhHocException hh) {
				System.err.println(hh.getMessage());
			}
			System.out.println("Ban them thanh cong! So Luong hinh hoc la: " + HinhHoc.counter);
			scanner.nextLine();
		}
	}
	//
}

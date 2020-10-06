package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Student;

public class Ex4_Encapsulation {

	public static void main(String[] args) {
		ex4Q1_b();
		ex4Q1_c();
		ex4Q1_d();
		ex4Q1_e();
	}

//		Question 1:
//			Tạo Object Student có các property id, name, hometown, điểm học lực
//			a) Tất cả các property sẽ để là private để các class khác không
//			chỉnh sửa hay nhìn thấy
//			b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
//			dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
//			c) Tạo 1 method cho phép set điểm vào
//			d) Tạo 1 method cho phép cộng thêm điểm
//			e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//			điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//			4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//			thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
//			Demo các chức năng trên bằng class ở front-end.
	public static void ex4Q1_b() {

		// b, Tạo constructor cho phép khi khởi tạo mỗi student thì người dùng sẽ nhập
		// vào tên, hometown và có điểm học lực = 0
		Student student = new Student("Ninh THi Hien ", "Nam Dinh ", 0f);
	}

	public static void ex4Q1_c() {

//c, Tạo 1 method cho phép set điểm vào
		Student student = new Student("hien", 2.7f);
		System.out.println(student.getPoints());
	}

	// d, Tạo 1 method cho phép cộng thêm điểm
	public static void ex4Q1_d() {

		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi nhap them diem vao: ");
		float point = scanner.nextFloat();
		student.setPoints(point);
		System.out.println(student.getPoints());
	}

	// e
	public static void ex4Q1_e() {
		Student student = new Student();
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap ten sv");
		String name1 = scanner.nextLine();
		student.setName(name1);				// nhap thong tin vao, dung set de cho phep chinh sua
		System.out.println("nhap diem sv");
		float point1 = scanner.nextFloat();
		student.setPoints(point1);

		if (student.getPoints() < 4) {
			System.out.println(student.getName() + ": Hoc sinh yeu"); // in ra
		} else if (student.getPoints() < 6) {
			System.out.println(student.getName() + " :Hoc sinh Trung binh");
		} else if (student.getPoints() < 8) {
			System.out.println(student.getName() + " :Hoc sinh Kha");
		} else if (student.getPoints() > 8) {
			System.out.println(student.getName() + " :Hoc sinh Gioi");
		}
	}

}

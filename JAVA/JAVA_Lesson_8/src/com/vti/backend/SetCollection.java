package com.vti.backend;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.vti.entity.Student;

public class SetCollection {
	static Set<Student> students = new HashSet<>();

//a, In ra tổng số phần tử của students
	public static void CountStudent() {
		students.add(new Student(1, "Hien"));
		students.add(new Student(2, "Lien"));
		students.add(new Student(3, "Hien"));
		students.add(new Student(4, "Thien"));
		students.add(new Student(5, "Huyen"));
		System.out.println("So luong student" + Student.counter);

	}

	// a1, in ra tat ca student
	public static void printStudent() {
		CountStudent();
		for (Student student : students) {
			System.out.println("Danh sach hoc sinh gom:\n" + student);
		}
	}

	// b, Lấy phần tử thứ 4 của students

	public void getStudentIndext4() {
		CountStudent();
		Iterator<Student> iterator = students.iterator();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}

	// Question 5: Tạo 1 danh sách có chứa name của các student không trùng nhau.
	// Sắp xếp theo name và in ra set đó
	// public static void TreeSet() {
	public static void TreeSetStudent() {
		TreeSet<Student> students = new TreeSet<Student>();
		students.add(new Student(1, "Hien"));
		students.add(new Student(2, "Lien"));
		students.add(new Student(3, "Hien"));
		students.add(new Student(4, "Thien"));
		students.add(new Student(5, "Huyen"));
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}

package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class AnnotationsQ1_2 {
	// Question1
	public void question1() {
		@SuppressWarnings("deprecation")
		Date date = new Date(2020, 05, 18);
		date.toString();
	}

//Question2:
	public void question2() {
		@SuppressWarnings("deprecation")
		Student student = new Student(1, "Nguyen Van A");
		
		System.out.println(student.getName());
		System.out.println(student.getId());
/**
 * @deprecated replace by {@link #getIdVIP()}
 */
		System.out.println(student.getIdVIP());
	}

	// Coordinate: De ben trong class thi de public, defaul duoc
	// con de ngoai class thi chi de: class Coordinate
	// private void Coordinate() {
	// TODO Auto-generated method stub
	//
	// }
}

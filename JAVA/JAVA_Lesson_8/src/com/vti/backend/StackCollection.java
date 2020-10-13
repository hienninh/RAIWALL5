package com.vti.backend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackCollection {
	// Stack
	public static void StackEx2() {
		Stack<String> student = new Stack<>();
		student.add("Nguyen Van Nam");
		student.add("Nguyen Van Huyen");
		student.add("Tran Van Nam");
		student.add("Nguyen Van A");
		System.out.println(student);
		student.push("Nguyen Van B");
		System.out.println(student);
		student.pop();
		student.pop();
		System.out.println(student);
	}

	// Queue
	public static void Queue() {
		Queue<String> students = new LinkedList<String>();
		students.add("Nguyen Van Nam");
		students.add("Nguyen Van Huyen");
		students.add("Tran Van Nam");
		students.add("Nguyen Van A");
		System.out.println(students);
		students.remove("Tran Van Nam");
		System.out.println(students);
	}
}

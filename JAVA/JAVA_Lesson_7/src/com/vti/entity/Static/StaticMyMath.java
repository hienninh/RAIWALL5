package com.vti.entity.Static;

import java.util.Scanner;

public class StaticMyMath {
	private static Scanner scanner;
// Question 3: static method
	public static void main(String[] args) {
		min(7, 10);
		sum(4, 5);
	}

	public static void min(int a, int b) {
		if (a < b) {
			System.out.println("Gia tri nho nhat la: " + a);
		} else
			System.out.println("Gia tri nho nhat la: " + b);
	}

	public static void sum(int c, int d) {
		int result = c + d;
		System.out.println("Tong cong la: " + result);
	}

}

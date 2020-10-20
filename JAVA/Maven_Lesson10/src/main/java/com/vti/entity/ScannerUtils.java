package com.vti.entity;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

// Question 7

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String str = scanner.nextLine();
				str = str.trim();
				int output = Integer.parseInt(str); // parseInt de chuyen String sang Integer (): Trả dữ liệu chuỗi
													// thành int
				return output;
			} catch (Exception e) {
				System.err.println(errorMessage); // In ra error
			}
			scanner.nextLine();
		}
	}

// Nhap so nguyen duong
	public static int intpositive(String errorMessage) {
		while (true) {
			try {
				int age = ScannerUtils.inputInt(errorMessage);
				if (age < 0) {
					System.err.println(errorMessage);
				} else {
					return age;
				}

			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}

	}

//Question 8
	// method inputFloat(), inputDouble(), inputString()
	// method inputFloat()
	public static float inputFloat(String errorMessage) {

		while (true) {
			try {
				String Floats = scanner.nextLine();
				return Float.parseFloat(Floats.trim());
			} catch (Exception e) {
				System.err.println(errorMessage);	
			}
			scanner.nextLine();
		}
	}

	// inputDouble()
	public static double inputDouble(String errorMessage) {
		while (true) {
			{
				String Doubles = scanner.nextLine();
				try {
					return Double.parseDouble(Doubles.trim());
				} catch (Exception e) {
					System.err.println(errorMessage);
				//	scanner.nextLine();
				}
			}
		}
	}

	// inputString
	public static String inputString() {
		while (true) {
			String string = scanner.nextLine().trim();
			if (string.isEmpty()) {
				System.out.println("Moi nhap lai, nhap vao 1 chuoi co ky tu");
			} else {
				return string;
			}
			scanner.nextLine();
		}
	}
}

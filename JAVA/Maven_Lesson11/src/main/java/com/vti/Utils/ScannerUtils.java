package com.vti.Utils;

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
					// scanner.nextLine();
				}
			}
		}
	}

	// inputString
	public static String inputString() {
		while (true) {
			String string = scanner.nextLine().replaceAll("\\s+", " ");
			String string1 = string.trim();
			if (string1.isEmpty()) {
				System.out.println("Moi nhap lai, nhap vao 1 chuoi co ky tu");
			} else {
				return string;
			}
			scanner.nextLine();
		}
	}

	// inputFullname
	public static String inputFullName() {
		String fullName = scanner.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
		String[] words = fullName.split(" ");
		fullName = "";

		for (String word : words) {
			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			fullName += word + " ";
		}
		return fullName;
	}

// inputEmail
	public static String email(String errorMessage) {
		while (true) {
			try {
				String email = scanner.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
				if (!email.contains("@gmail.com")) {
					System.err.println(errorMessage);
				} else {
					return email;
				}
			} catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}
}

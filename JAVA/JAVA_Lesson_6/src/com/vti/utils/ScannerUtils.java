package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String number = scanner.nextLine();
				return Integer.parseInt(number.trim()); // parseInt de chuyen String sang Integer (): Trả dữ liệu chuỗi
														// thành int
			} catch (Exception e) {
				System.err.println(errorMessage); // In ra error
			}
		}
	}

	public static void age() {
	}

	public static void id() {
	}

	// method inputFloat(), inputDouble(), inputString()
	// method inputFloat()
	public static float inputFloat(String errorMessage) {
		String Floats = scanner.nextLine();
		while (true) {
			{
				try {
					return Float.parseFloat(Floats.trim());

				} catch (Exception e) {
					System.err.println(errorMessage);
				}
			}
		}
	}

	// inputDouble()
	public static double inputDouble(String errorMessage) {
		String Doubles = scanner.nextLine();
		while (true) {
			{
				try {
					return Double.parseDouble(Doubles.trim());

				} catch (Exception e) {
					System.err.println(errorMessage);
				}
			}
		}
	}

	// inputString
	public static String inputString() {
		String string = scanner.nextLine().trim();

		while (true) {
			if (string.isEmpty()) {
				System.out.println("Moi nhap lai, nhap vao 1 chuoi co ky tu");
			} else {
				return string;
			}
		}
	}
}

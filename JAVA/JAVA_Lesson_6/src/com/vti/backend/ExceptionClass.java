package com.vti.backend;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.utils.NumberLessThanZeroException;

public class ExceptionClass {
	public static void main(String[] args) {

		// Question1_2();
		// Question3();
		try {
			// getIndex(1);
		} catch (IndexOutOfBoundsException iob) {
			System.out.println(iob.getMessage());
		}
		// inputAge();
		//inputage();

		Question7();
	}

	public static void Question1_2() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("cannot divide 0");
		} finally {
			System.out.println("divide completed!");
		}
	}

	private static float divide(int a, int b) {
		return a / b;
	}

	// Question 3:
	public static void Question3() {
		int[] numbers = { 1, 2, 3 };
		try {
			System.out.println(numbers[10]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("number nam ngoai mang cho truoc. chi in number [0 den 3]");
		}
	}
	// Question 4:
//	Tạo 1 array departments gồm 3 phần tử
//	Sau đó viết 1 method getIndex(int index) để lấy thông tin phần tử thứ
//	index trong array departments. Nếu index vượt quá length lấy ra thì sẽ
//	in ra text "Cannot find department."

	public static void getIndex(int index) {
		// Create departments
		Department[] departments = new Department[3];
		departments[0] = new Department((byte) 0, "Nguyen A");
		departments[1] = new Department((byte) 1, "Nguyen B");
		departments[2] = new Department((byte) 2, "Nguyen C");

		try {
			System.out.println(departments[index]);
		} catch (IndexOutOfBoundsException iob) {
			throw new IndexOutOfBoundsException("Cannot find department");
		}
	}

	// Question 5
	public static void inputAge() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Moi ban nhap vao tuoi: ");
			int age = scanner.nextInt();
			if (age < 0) {
				throw new NumberLessThanZeroException(
						"Wrong inputing! The age must be greater than 0," + " please input again.");
			}
			System.out.println("Tuoi cua ban la: " + age);
		} catch (InputMismatchException im) { // Error cua java thuc hien truoc error tu tao
			System.out.println("wrong inputing! Please input an age as int, input again");
		} catch (NumberLessThanZeroException nltz) {
			System.out.println("Exception occured: " + nltz.getMessage()); // bien cua error tu tao se ke thua Exeption
		} finally {
			scanner.close();
		}

	}

// Question 6:
	public static void inputage() {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Moi ban nhap vao tuoi");
			int age = scanner.nextInt();
			System.out.println("Tuoi cua ban la: " + age);
		} catch (InputMismatchException im) {
			System.out.println("wrong inputing! Please input an age as int, input again");
		} finally {
			System.out.println("Ngư�?i dùng nhập lại");
		}
	}

// Question 9: 
	public static void Question7() {
		Department department = new Department();
		System.out.println("Thong tin phong ban la :\n" + department);
	}
}

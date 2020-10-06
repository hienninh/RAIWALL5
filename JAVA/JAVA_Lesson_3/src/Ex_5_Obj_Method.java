
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex_5_Obj_Method {

	public static void main(String[] args) {
		// creat Department
		Department saleDepartment = new Department();
		saleDepartment.id = 3;
		saleDepartment.name = "Sale";

		Department marketingDepartment = new Department();
		marketingDepartment.id = 5;
		marketingDepartment.name = "Marketing";

		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Accounting";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Boss of director";

		Department department3 = new Department();
		department3.id = 4;
		department3.name = "waiting room";

		Department[] departmens = { saleDepartment, marketingDepartment };

		Department[] department6 = { saleDepartment, marketingDepartment, department1, department2, department3 };

//		Question_5_1(saleDepartment);
//		Question_5_2(departmens);
//		Question_5_3(saleDepartment);
//		Question_5_4(saleDepartment);
//		Question_5_5(saleDepartment, marketingDepartment);
		Question_5_6(department6);
	}

//	Exercise 5: Object’s Method
//	Question 1:
//	In ra thông tin của phòng ban thứ 1 (sử dụng toString())
	// creat Department
	public static void Question_5_1(Department saleDepartment) {
		System.out.println(saleDepartment);
	}

//	Question 2:
//	In ra thông tin của tất cả phòng ban (sử dụng toString())
	public static void Question_5_2(Department[] departmens) {
		for (Department department : departmens) {
			System.out.println(department);
		}
	}

//	Question 3:
//		In ra địa chỉ của phòng ban thứ 1
	public static void Question_5_3(Department saleDepartment) {
		System.out.println(saleDepartment.hashCode());
	}

//	Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
	public static void Question_5_4(Department saleDepartment) {
		System.out.println(saleDepartment.name.equals("Phong A"));
	}

//	Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//	không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	public static void Question_5_5(Department saleDepartment, Department marketingDepartment) {
		System.out.println(marketingDepartment.equals(saleDepartment));
	}

//	Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh 
//	sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)

	public static void Question_5_6(Department[] department6) {
		for (Department departmentn : department6) {
			String fisrtCharacter = departmentn.name.substring(0, 1);
			System.out.print(fisrtCharacter);
		}

		String fisrtCharacter = "";
		byte[] array = fisrtCharacter.getBytes();
		for (int j = 0; j < array.length; j++) {
			System.out.println(array[j]+ "");
		}

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

//		int[] ints = { 11367, 11358, 11421, 11530, 11491, 11218, 11789 };
//		Arrays.sort(ints);
//		System.out.println(Arrays.toString(ints));

	}
	}

//	Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh
//	sách phòng ban được sắp xếp theo tên
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	waiting room
//	Sale


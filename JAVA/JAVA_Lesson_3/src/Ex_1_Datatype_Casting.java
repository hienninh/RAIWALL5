import java.util.Random;
import java.util.Scanner;

public class Ex_1_Datatype_Casting {

	public static void main(String[] args) {
//		Question_1();
//		Question_2();
//		Question_2bs();

//		Question_3();
//		Question_4();
	}
//	Exercise 1 (Optional): Datatype Casting
//	Question 1:
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

	public static void Question_1() {
		double account_1 = 5240.5f;
		double account_2 = 10970.055f;
		int account_1_i = (int) account_1;
		int account2_i = (int) account_2;
		System.out.println("Luong cua account 1 lam tron la: " + account_1_i);
		System.out.println("Luong cua account 2 lam tron la: " + account2_i);
	}

//Question 2:
//	Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//	có số 0 ở đầu cho đủ 5 chữ số)

	public static void Question_2() {
		Random random = new Random();
		int x = random.nextInt(99999);
		String y = x + "";

		switch (y.length()) {
		case 1:
			System.out.println("0000" + y);
			break;
		case 2:
			System.out.println("000" + y);
			break;
		case 3:
			System.out.println("00" + y);
			break;
		case 4:
			System.out.println("0" + y);
			break;
		default:
			System.out.println(y);
			break;

		}
	}

//	Question 2bs:Viết chương trình nhập vào 1 số nguyên dương bất kỳ nhập từ bàn phím. Đếm và in ra màn hình số chữ số của số đó.		
	public static void Question_2bs() {
		int number, count = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập vào 1 số nguyên dương bất kỳ: ");
		number = scanner.nextInt();

		while (number <= 0) {
			System.out.println("Số nhập vào phải lớn hơn 0. Mời bạn nhập lại: ");
			number = scanner.nextInt();
		}

		while (number > 0) {
			number /= 10;
			count++; // tăng biến count lên 1
		}
		System.out.println("Số các chữ số = " + count);
	}

//Question 3:
//	Lấy 2 số cuối của số ở Question 2 và in ra.
//	Gợi ý:
//	Cách 1: convert số có 5 chữ số ra St
//	Cách 2: chia lấy dư số đó cho 100

// cach 1:
	public static void Question_3() {
		Random random = new Random();
		int x = random.nextInt(99999 - 10000 + 1) + 10000;

		String str = x + "";
		System.out.println(str);
		char str3 = str.charAt(3);
		char str4 = str.charAt(4);
		System.out.println(str3 + "" + str4);
	}

//Question 4:
//	Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	public static void Question_4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao  2 so nguyen:");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		float c = (float) a / b;
		System.out.println("Dap an a/b la: " + c);
	}

}

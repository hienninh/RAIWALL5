import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Extra_2 {

	public static void main(String[] args) {
//		Question1();
//		Question2();
//		Question4();
//		Question3();
//		Question5();
		Question6();

	}
//		Question 1:
//			Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet
//			(cm).
//			Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch
//			(số thực, có 2 số lẻ thập phân).
//			Với 1 inch = 2.54 cm và 1 foot = 12 inches

	public static void Question1() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Moi ban nhap vao 1 so thuc: ");
		float x = scan.nextFloat();
		float y = x / 2.54f;
		float z = (x / 2.54f) / 12f;
		System.out.println("So inch tuong ung la:" + y);
		System.out.println("So foot tuong ung la:" + z);
	}

//		Question 2:
//			Viết chương trình nhập vào số giây từ 0 tới 68399, đổi số giây này thành dạng
//			[giờ:phút:giây], mỗi thành phần là một số nguyên có 2 chữ số.
//			Ví dụ: 02:11:05	

	public static void Question2() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Moi ban nhap so giay :");
		int x3 = scan.nextInt();
		int hours = x3 / 3600; // / la lay phan nguyen, % la lay phan du
		int minutes = x3 % 3600 / 60;
		int second = x3 % 3600 % 60;
		System.out
				.println(" Dinh dang HH-mm-ss la: \n" + hours + " Hour " + minutes + " Minute " + second + " Seconds ");
	}

//	    Question 3:
//	    	Viết chương trình nhập vào 4 số nguyên.
//	    	Hiển thị ra số lớn nhất và nhỏ nhất
//	    	Ví dụ:
//	    	nhập vào 4 số 1,2,3,4 thì kết quả là:
//	    	Số lớn nhất là: 4
//	    	Số nhỏ nhất là: 1

	public static void Question3() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Moi ban nhap vao 4 so nguyen!");
		int[] numbers = new int[4];
		// Max

		for (int i = 0; i < numbers.length; i++) {
			System.out.print("Ban vua nhap vao so nguyen thu " + (i + 1) + " la: ");
			numbers[i] = scanner.nextInt();
		}

		int max = numbers[0];
		int min = numbers[0];
		for (int j = 0; j < numbers.length; j++) {
			if (numbers[j] > max)
				// if (max < numbers[j]) hoặc
				max = numbers[j];
			// numbers[j] = max;} máy tính hiểu max = numbers[0]
			if (numbers[j] < min) {
				min = numbers[j];
			}
		}
		System.out.println("Gia tri nho nhat la:" + min);
		System.out.println("Gia tri lon nhat la: " + max);
	}

//		Question 4:
//			Nhập vào hai số tự nhiên a và b. Tính hiệu của hai số đó.
//			Nếu hiệu số lớn hơn 0 thì in ra dòng chữ [Số thứ nhất lớn hơn số thứ
//			hai].
//			Nếu hiệu số nhỏ hơn 0 thì in ra dòng chữ [Số thứ nhất nhỏ hơn số thứ
//			hai].
	public static void Question4() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Moi ba nhap vao 2 so nguyen");
		int x1 = scan.nextInt();
		int x2 = scan.nextInt();
		System.out.println("Hai so nguyen la:" + x1 + "  " + "va" + "  " + x2);
		if (x1 > x2) {
			System.out.println("Số thứ nhất lớn hơn số thứ hai");
		} else {
			System.out.println("Số thứ nhất nhỏ hơn số thứ hai");
		}
		;
	}

//	    Question 5:
//	    	Nhập vào 2 số tự nhiên a và b. Kiểm tra xem a có chia hết cho b không

	public static void Question5() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Moi ba nhap vao 2 so tu nhien");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("Hai so nguyen la:" + a + "  " + "va" + "  " + b);
		if (a % b == 0) {
			System.out.println("a chia het cho b bang = " + " " + a / b);
		} else {
			System.out.println("a khong chia het cho b");
		}

	}

//	Question 6:
//		Xếp loại sinh viên theo các qui luật dưới đây:
//		Nếu điểm >= 9.0 - Loại xuất sắc
//		Nếu 8.0<= điểm < 9.0 - Loại giỏi
//		Nếu 7.0<= điểm < 8.0 - Loại khá 
//		Nếu 6.0 <= điểm < 7.0 - Loại trung bình khá
//		Nếu 5.0 <= điểm < 6.0 - Loại trung bình
//		Nếu điểm < 5.0 - Loại kém
//		Với điểm = ( (điểm toán)*2 + điểm lý + điểm hóa )/4
//		Viết Chương trình:
//		a. Nhập vào điểm 3 môn học
//		b. Tính điểm trung bình
//		c. Xác định học lực của học sinh dựa trên điểm trung bình
//		d. Hiển thị học lực của học sinh
	public static void Question6() {
		// Nhập vào điểm 3 môn học

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao diem 3 mon hoc: ");
		float[] points = new float[3];

		for (int i = 0; i < points.length; i++)
			points[i] = scanner.nextFloat();
		{
			System.out.println("Diem mon Toan la: " + points[0]);
			System.out.println("Diem mon Ly la: " + points[1]);
			System.out.println("Diem mon Hoa la: " + points[2]);
		}
		// Tinh diem trung binh

		float AVG = (points[0] * 2 + points[1] + points[2]) / 4f;
		if (AVG >= 9.0) {
			System.out.println("Hoc sinh xep loai xuat sac va diem la: " + AVG);
		} else if (AVG >= 8.0) {
			System.out.println("Hoc sinh xep loai gioi va diem la: " + AVG);
		} else if (AVG >= 7.0) {
			System.out.println("Hoc sinh xep loai kha va diem la: " + AVG);
		} else if (AVG >= 5) {
			System.out.println("Hoc sinh xep loai Trung binh va diem la: " + AVG);
		} else {
			System.out.println("Hoc sinh xep loai Trung binh kha va diem la: " + AVG);
		}

	}
}

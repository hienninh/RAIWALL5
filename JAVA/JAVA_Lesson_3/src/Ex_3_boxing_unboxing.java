
public class Ex_3_boxing_unboxing {

	public static void main(String[] args) {
//		Question_3_1();
//		Question_3_2();
//		Question_3_3();
	}
//	Exercise 3(Optional): Boxing & Unboxing
//	Question 1:
//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//	float có 2 số sau dấu thập phân)	
	// cach 1:
	public static void Question_3_1() {
		Integer a = 5000;
		float b = (float) a;
		String c = b + "0";
		System.out.println(c);
		// cach 2:
		System.out.printf("%5.2f", b); // khoang trang . 2 so sau dau thap phan
	}

//	Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int
	public static void Question_3_2() {
		String str = "1234567";
		Integer value = Integer.parseInt(str); // return parseInt(s,10) , voi 10 la count cac chu so cua so int
		System.out.println(value);
	}

//	Question 3:
//		Khởi tạo 1 số Integer có value là chữ "1234567"
//		Sau đó convert số trên thành datatype int
	public static void Question_3_3() {
		Integer x = 1234567;
		int y = x.intValue(); // return value
		System.out.println(y);
	}

}

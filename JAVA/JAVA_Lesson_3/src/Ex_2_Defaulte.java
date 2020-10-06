
public class Ex_2_Defaulte {

	public static void main(String[] args) {
//		Question_2_1();
	}
//	Exercise 2 (Optional): Default value
//	Question 1:
//	Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//	tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//	 Email: "Email 1"
//	 Username: "User name 1"
//	 FullName: "Full name 1"
//	 CreateDate: now

	public static void Question_2_1() {
// Tao Account moi va  in ra

		Account[] accounts = new Account[5];
		for (int i = 0; i < 5; i++) {
			accounts[i] = new Account();
			accounts[i].email = "Email " + (i + 1);
			accounts[i].fullName = "Full name " + (i + 1);
			accounts[i].userName = "User Name " + (i + 1);
			System.out.println("Email cua tai khoan " + (i + 1) + " la: " + accounts[i].email);
			System.out.println("fullName cua tai khoan " + (i + 1) + " la: " + accounts[i].fullName);
			System.out.println("userName cua tai khoan " + (i + 1) + " la: " + accounts[i].userName);
			System.out.println("\n");
		}

	}
}

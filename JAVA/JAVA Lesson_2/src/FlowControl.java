import java.text.DateFormat;
import java.time.LocalDate;

public class FlowControl {
	public static void main(String[] args) {

		// Logic
		// Create Department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketting";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "purchasing";

		// Create Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "c#";

		Group group2 = new Group();
		group2.id = 1;
		group2.name = "Java Basic";

		Group group3 = new Group();
		group3.id = 1;
		group3.name = "Java Import";

		// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.DEV;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.TEST;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.TEST;

		// Create Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "Nguyenminh@gmail.com";
		account1.userName = "Nguyenminh";
		account1.fullName = "Nguyen Van Minh";
		account1.department = department2;
		account1.position = position1;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "tranle@gmail.com";
		account2.userName = "tranle";
		account2.fullName = "Tran Le Anh";
		account2.department = department2;
		account2.position = position2;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "Lean@gmail.com";
		account3.userName = "Lean";
		account3.fullName = "Le Hoai AN";
		account3.department = department1; // lay thong tin tu bang Department
		account3.position = position1;
		account3.cearteDate = LocalDate.of(2019, 12, 01);
		// Create GroupAccount
		GroupAccount groupAccount1 = new GroupAccount();
		groupAccount1.group = group1; // lay thong tin tu bang Group
		groupAccount1.account = account1;
		groupAccount1.joinDate = LocalDate.of(2019, 11, 01);

		GroupAccount groupAccount2 = new GroupAccount();
		groupAccount2.group = group2;
		groupAccount2.account = account1;
		groupAccount2.joinDate = LocalDate.of(2019, 10, 01);

		GroupAccount groupAccount3 = new GroupAccount();
		groupAccount3.group = group3;
		groupAccount3.account = account2;
		groupAccount3.joinDate = LocalDate.of(2019, 11, 01);

		// lay tat ca Group thuoc Account1, lay ca joinDate
		GroupAccount[] GroupAccount1 = { groupAccount1, groupAccount2 };
		account1.groupAccounts = GroupAccount1;

		// lay tat ca Group thuoc Account2, lay ca joinDate
		GroupAccount[] GroupAccount2 = { groupAccount1, groupAccount3 };
		account2.groupAccounts = GroupAccount2;

// Question 1:
		if (account2.department == null) {
			System.out.println("Nhân viên này chưa  có group");
		} else {
			System.out.println("Phòng ban của nhân viên này là:" + account2.department.name);
		}

// Question 2:
		if (account2.groupAccounts == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} // null

		else if (account2.groupAccounts.length == 1 || account2.groupAccounts.length == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} // account tham gia 1 or 3 Group

		else if (account2.groupAccounts.length >= 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} // account tham gia nhieu hon 3 Groups

		else if (account2.groupAccounts.length >= 4) {
			System.out.println("Nhân viên này là người hong chuyen, tham gia tất cả các group"); }
		// account tham gia nhieu hon 4 Groups
				

// print account2 

		for (GroupAccount groupOfAccount2 : account2.groupAccounts) { // bang -- Bien -- : ten thong tin can in. bang
			System.out.println(groupOfAccount2.group.name);
		}
		/*
		 * Exercise 3 (Optional): Date Format 
		 * Question 1: In ra thông tin Exam thứ 1 và
		 * property create date sẽ được format theo định dạng vietnamese
		 */
		Locale locale = new Locale("vi","VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(date)
 
	}
}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class FlowControl {

	public static void main(String[] args) {
		// Create departments
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "IT";

		// Create positions
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.DEV;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.TEST;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.PM;

		// Create accounts
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "nguyenvana@gmail.com";
		account1.userName = "nguyenvana";
		account1.fullName = "Nguyen Van A";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDate.of(2020, 6, 1);

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "lethib@gmail.com";
		account2.userName = "lethib";
		account2.fullName = "Le Thi B";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = LocalDate.of(2020, 6, 2);

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "tranvanc@gmail.com";
		account3.userName = "tranvanc";
		account3.fullName = "Tran Van C";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = LocalDate.of(2020, 6, 3);

		
		// Create groups
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "C++ Fresher";
		group1.creator = account1;
		group1.createDate = LocalDate.of(2020, 6, 1);

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Java Fresher";
		group2.creator = account2;
		group2.createDate = LocalDate.of(2020, 6, 2);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "C# Fresher";
		group3.creator = account3;
		group3.createDate = LocalDate.of(2020, 6, 3);

		Group[] groupsOfAccount1 = { group1, group2 };
		account1.groups = groupsOfAccount1;

		Group[] groupsOfAccount2 = { group2, group3 };
		account2.groups = groupsOfAccount2;

		Group[] groupsOfAccount3 = { group1, group3 };
		account3.groups = groupsOfAccount3;

		Account[] accountsOfGroup1 = { account1, account3 };
		group1.accounts = accountsOfGroup1;

		Account[] accountsOfGroup2 = { account1, account2 };
		group2.accounts = accountsOfGroup2;

		Account[] accountsOfGroup3 = { account2, account3 };
		group3.accounts = accountsOfGroup3;

		// Create types of question
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.name = TypeName.ESSAY;

		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.name = TypeName.MULTIPLE_CHOICE;

		// Create categories of question
		CategoryQuestion category1 = new CategoryQuestion();
		category1.id = 1;
		category1.name = "Java";

		CategoryQuestion category2 = new CategoryQuestion();
		category2.id = 2;
		category2.name = ".NET";

		CategoryQuestion category3 = new CategoryQuestion();
		category3.id = 3;
		category3.name = "SQL";

		// Create questions
		Question question1 = new Question();
		question1.id = 1;
		question1.content = "Question 1";
		question1.category = category1;
		question1.type = type1;
		question1.creator = account1;
		question1.createDate = LocalDate.of(2020, 6, 1);

		Question question2 = new Question();
		question2.id = 2;
		question2.content = "Question 2";
		question2.category = category2;
		question2.type = type2;
		question2.creator = account2;
		question2.createDate = LocalDate.of(2020, 6, 2);

		Question question3 = new Question();
		question3.id = 3;
		question3.content = "Question 3";
		question3.category = category3;
		question3.type = type1;
		question3.creator = account3;
		question3.createDate = LocalDate.of(2020, 6, 3);

		// Create answers
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Answer 1";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "Answer 2";
		answer2.question = question2;
		answer2.isCorrect = false;

		Answer answer3 = new Answer();
		answer3.id = 3;
		answer3.content = "Answer 3";
		answer3.question = question3;
		answer3.isCorrect = true;

		// Create exams
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "Code 1";
		exam1.title = "Title 1";
		exam1.category = category1;
		exam1.duration = 60;
		exam1.creator = account1;
		exam1.createDate = LocalDate.of(2020, 6, 1);

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "Code 2";
		exam2.title = "Title 2";
		exam2.category = category2;
		exam2.duration = 90;
		exam2.creator = account2;
		exam2.createDate = LocalDate.of(2020, 6, 2);

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "Code 3";
		exam3.title = "Title 3";
		exam3.category = category3;
		exam3.duration = 180;
		exam3.creator = account3;
		exam3.createDate = LocalDate.of(2020, 6, 3);

		Exam[] examsOfQuestion1 = { exam1, exam2 };
		question1.exams = examsOfQuestion1;

		Exam[] examsOfQuestion2 = { exam2, exam3 };
		question2.exams = examsOfQuestion2;

		Exam[] examsOfQuestion3 = { exam1, exam3 };
		question3.exams = examsOfQuestion3;

		Question[] questionsOfExam1 = { question1, question3 };
		exam1.questions = questionsOfExam1;

		Question[] questionsOfExam2 = { question1, question2 };
		exam2.questions = questionsOfExam2;

		Question[] questionsOfExam3 = { question2, question3 };
		exam3.questions = questionsOfExam3;

		// IF
		// Question 1
		if (account2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là: " + account2.department.name);
		}
		System.out.println("\n");

		// Question 2
		if (account2.groups.length == 0) {
			System.out.println("Nhân viên này chưa thuộc group nào");
		} else if (account2.groups.length == 1 || account2.groups.length == 2) {
			System.out.println("Group của nhân viên này là:");
			for (Group group : groupsOfAccount2) {
				System.out.println(group.name);
			}
		} else if (account2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else if (account2.groups.length >= 4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		System.out.println("\n");

		// Question 3
		System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là: " + account2.department.name);
		System.out.println("\n");

		// Question 4
		System.out.println(
				account1.position.name == PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");
		System.out.println("\n");

		// SWITCH CASE
		// Question 5
		switch (group1.accounts.length) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}
		System.out.println("\n");

		// Question 6
		switch (account2.groups.length) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
		case 2:
			System.out.println("Group của nhân viên này là:");
			for (Group group : groupsOfAccount2) {
				System.out.println(group.name);
			}
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		case 4:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		default:
			break;
		}
		System.out.println("\n");

		// FOREACH
		// Question 8
		Account[] accounts = { account1, account2, account3 };
		int i = 1;
		for (Account account : accounts) {
			System.out.println("Thông tin account thứ " + i + " là:");
			System.out.println("Email: " + account.email);
			System.out.println("Full Name: " + account.fullName);
			System.out.println("Phòng ban: " + account.department.name);
			System.out.println("\n");
			i++;
		}

		// Question 9
		Department[] departments = { department1, department2, department3 };
		
		i = 1;
		for (Department department : departments) {
			System.out.println("Thông tin department thứ " + i + " là:");
			System.out.println("Id: " + department.id);
			System.out.println("Name: " + department.name);
			System.out.println("\n");
			i++;
		}

		// FOR
		// Question 10
		for (i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phòng ban: " + accounts[i].department.name);
			System.out.println("\n");
		}

		// Question 11
		for (i = 0; i < departments.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
		}

		// Question 12
		for (i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
		}

		// Question 13
		for (i = 0; i < accounts.length; i++) {
			if (i == 1) {
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phòng ban: " + accounts[i].department.name);
			System.out.println("\n");
		}

		// Question 14
		for (i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phòng ban: " + accounts[i].department.name);
				System.out.println("\n");
			}
		}

		// Question 15
		for (i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("\n");

		// WHILE
		// Question 10
		i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phòng ban: " + accounts[i].department.name);
			System.out.println("\n");
			i++;
		}

		// Question 11
		i = 0;
		while (i < departments.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
			i++;
		}

		// Question 12
		i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
			i++;
		}

		// Question 13
		i = 0;
		while (i < accounts.length) {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phòng ban: " + accounts[i].department.name);
			System.out.println("\n");
			i++;
		}
		// Question 14
		i = 0;
		while (i < accounts.length) {
			if (accounts[i].id < 4) 
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full Name: " + accounts[i].fullName);
				System.out.println("Phòng ban: " + accounts[i].department.name);
				System.out.println("\n");
				i++;
		}
			
		// Question 15
		int y = 0;
		while (y < 20) {
		if (y % 2 == 0)
		System.out.println(y);
		y++ ;}
		
//DO-WHILE
//		Question 17:
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
		
// Question 10
		i = 0;
		do 
		{
		System.out.println("Thông tin account thứ " + (i + 1) + " là:");
		System.out.println("Email: " + accounts[i].email);
		System.out.println("Full Name: " + accounts[i].fullName);
		System.out.println("Phòng ban: " + accounts[i].department.name);
		System.out.println("\n");
		 i++ ;
		} while (i < accounts.length);
// Question 11: 
		
		i = 0;
		do {System.out.println("Thông tin department thứ " + (i + 1) + " là:");
		System.out.println("Id: " + departments[i].id);
		System.out.println("Name: " + departments[i].name);
		System.out.println("\n");
		i++;
		} while ( i < departments.length);
		
// Question 12:
		i = 0;
		do {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
			i++;
		} while (i < 2);
// Question 13:
		i = 0;
		do {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phòng ban: " + accounts[i].department.name);
			System.out.println("\n");
			i++;
		} while (i < accounts.length);

// Question 14:
		i = 0;
		do {if (i < 4)
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Phòng ban: " + accounts[i].department.name);
			System.out.println("\n");
			i++;
		} while (i < accounts.length);

// Question 15:
		int z = 0;
		do {if (z % 2 == 0)
			System.out.println(z);
		z++ ;}
		while (z < 20);
		
		
//System out printf
//		Exercise 2 (Optional): 
//		Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
		int j = 5;
		System.out.println(j);
//		Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//		ra số nguyên đó thành định dạng như sau: 100,000,000
		
		int x = 100000000;
		System.out.printf(Locale.US, "%,d", 100000000);
		
//		Question 3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//		thực đó chỉ bao gồm 4 số đằng sau
	
		System.out.printf("'%7.4f'%n", 5.567098);
		
//		Question 4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
//		Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//		Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		
		System.out.printf ("'%s' %n", " Ten toi la: Nguyen Van A va toi dang doc than");
		
//		Question 5:
//		Lấy thời gian bây giờ và in ra theo định dạng sau:
//		24/04/2020 11h:16p:20s
		
		Date date = new Date();
		System.out.printf("%1$td/ %1$tm/ %1$ty %n %tHh:%tMp:%tS%ns",date, date, date, date);
		System.out.println();
		

//		( Chua )Question 6:
//		In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//		table (giống trong Database)
		
//	Exercise 3 (Optional): Date Format
//		Question 1: In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//		dạng vietnamese
		
		System.out.println(exam1.createDate);
		
		// localdate --> date
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date dateObject = Date.from(exam1.createDate.atStartOfDay(defaultZoneId).toInstant());

		// date --> String
		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String dateString = dateFormat.format(dateObject);
		System.out.println(dateString);
		
//		Question 2: In ra thông tin: Exam đã tạo ngày nào theo định dạng
//		Năm – tháng – ngày – giờ – phút – giây
// pattern date
		// exam1.createDate
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateString2 = simpleDateFormat.format(dateObject);
		System.out.println(dateString2);
		
		
		//new Date()
		String pattern2 = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		String date2 = simpleDateFormat2.format(new Date());
		System.out.println(date2);

//		Question 3: Chỉ in ra năm của create date property trong Question 2
		
		String patterny = "yyyy";
		SimpleDateFormat simpleDateFormaty = new SimpleDateFormat(patterny);
		String dateStringy = simpleDateFormaty.format(dateObject);
		System.out.println(dateStringy);

//		Question 4: Chỉ in ra tháng và năm của create date property trong Question 2
		
		String patternMy = "MM-yyyy";
		SimpleDateFormat simpleDateFormatMy = new SimpleDateFormat(patternMy);
		String dateStringMy = simpleDateFormatMy.format(dateObject);
		System.out.println(dateStringMy);
		
//		Question 5: Chỉ in ra "MM-DD" của create date trong Question 2
		
		String patternMd = "MM-dd";
		SimpleDateFormat simpleDateFormatMd = new SimpleDateFormat(patternMd);
		String dateStringMd = simpleDateFormatMd.format(dateObject);
		System.out.println(dateStringMd);

// Exercise 4 (Optional): Random Number
		
// Exercise 5: Input from console
//		Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		
//		Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
//		Question 3: Viết lệnh cho phép người dùng nhập họ và tên
//		Question 4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
//		Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method)
//		Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//		chương trình sẽ chuyển thành Position.Dev, Position.Test,
//		Position.ScrumMaster, Position.PM
		// 
	

	}
}

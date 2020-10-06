import java.util.Scanner;

public class Ex_4_String {

	public static void main(String[] args) {

//		Question_4_1();
//		Question_4_2();
//		Question_4_3();
//		Question_4_4();
//		Question_4_5();
//		Question_4_6();
//		Question_4_7();
//		Question_4_8();
//		Question_4_10();
//		Question_4_11();
//		Question_4_12();
//		Question_4_13();
//		Question_4_14();
//		Question_4_15();
//		Question_4_16();

	}
//	Exercise 4: String
//	Question 1:
//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//	thể cách nhau bằng nhiều khoảng trắng );

	public static void Question_4_1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ba nhap vao mot chuoi: ");
		String str = scanner.nextLine();

		System.out.println("Do dai cua chuoi la :" + str.length());
	}

//	Question 2:
//	Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;

	public static void Question_4_2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi s1");
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();

		System.out.println(s1 + " " + s2);
		System.out.println("Sau khi nối chuỗi : " + s1.concat(s2)); // them dau cach dua s1 va s2
	}
//	Question 3:
//	Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chưa
//	viết hoa chữ cái đầu thì viết hoa lên

	public static void Question_4_3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ten: ");
		String Name = scanner.nextLine();
		String firstChar = Name.substring(0, 1).toUpperCase();
		String laststr = Name.substring(1).toLowerCase();
		Name = firstChar + laststr;
		System.out.println(Name);

	}

//	Question 4:
//	Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//	của người dùng ra
//	VD:
//	Người dùng nhập vào "Nam", hệ thống sẽ in ra
//	"Ký tự thứ 1 là: N"
//	"Ký tự thứ 1 là: A"
//	"Ký tự thứ 1 là: M" 
	public static void Question_4_4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ten: ");
		String Name = scanner.nextLine();
		for (int i = 0; i < Name.length(); i++)
			System.out.println(Name.substring(i, i + 1));
	}

//	Question 5:
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//		dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	public static void Question_4_5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ho: ");
		String firstName = scanner.nextLine();
		System.out.println("Moi ban nhap vao ten: ");
		String lastName = scanner.nextLine();

		System.out.println("Ten day du la: " + firstName + " " + lastName);
	}

//		Question 6:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//		VD:
//		Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra
//		"Họ là: Nguyễn"
//		"Tên đệm là: Văn"
//		"Tên là: Nam"
	public static void Question_4_6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ten day du: ");
		String fullName = scanner.nextLine();
		String fisrtName = "", middleName = "", lastName = "";
		String[] words = fullName.split(" ");
		fisrtName = words[0];
		middleName = words[1];
		lastName = words[2];

		System.out.println("Ho la: " + words[0]);
		System.out.println("Ten dem la: " + words[1]);
		System.out.println("Ten la: " + words[2]);
	}
//		Question 7: chua hieu
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		chuẩn hóa họ và tên của họ như sau:
//		a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "nguyễn văn nam"
//		b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "Nguyễn Văn Nam"

	public static void Question_4_7() {
		// a
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ten day du: ");
		String fullName = scanner.nextLine();
		fullName = fullName.replaceAll("\\s+", " ");
		System.out.println("Ten day du la: " + fullName.trim());
		// b
		String[] words = fullName.split(" ");
		fullName = " ";

		for (String word : words) {
			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			fullName += word + " ";
			System.out.println("Ho va ten sau khi chuan hoa la: " + fullName);
		}

	}

//		Question 8:
//		In ra tất cả các group có chứa chữ "Java"
	public static void Question_4_8() {
		String[] groupNames = { "java", "hoi yeu java", "muon hoc java", "  yeu cong nghe  " };

		for (String groupName : groupNames) {
			if (groupName.contains("java"))
				System.out.println("Nhom co chua tu java la: " + groupName.trim());
		}
		for (String groupName : groupNames) {
			if (groupName.equals("java"))
				System.out.println("Nhom ten java: " + groupName);
		}
	}
//	Question 9:
//		In ra tất cả các group "Java"

//		Question 10 (Optional):  reverts va so sanh string la equals
//		Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//		Nếu có xuất ra “OK” ngược lại “KO”.
//		Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
	public static void Question_4_10() {
		// nhap thong tin s1 va s2
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi s1: ");
		String s1 = scanner.nextLine();
		s1 = s1.replaceAll("\\s+", " ");

		System.out.println("Moi ban nhao vao chuoi s2 de so sanh: ");
		String s2 = scanner.nextLine();
		s2 = s2.replaceAll("\\s+", " ");
		String reverses1 = "";
		// in ra chuoi dao nguoc reverses1 cua s1
		for (int i = s1.length() - 1; i >= 0; i--) {

			reverses1 += s1.charAt(i);
		}
		System.out.println(reverses1);

		if (s2.equals(reverses1)) {
			System.out.println();
			System.out.println("Day la chuoi dao nguoc cua s1");
		} else {
			System.out.println("Day khong phai chuoi dao nguoc cua s1 ");
		}

	}

//		Question 11 (Optional): Count special Character
//		Tìm số lần xuất hiện ký tự "a" trong chuỗi
	public static void Question_4_11() {
		Scanner scanner = new Scanner(System.in);
		String str = "";

		System.out.println("Mời bạn nhập vào một chuỗi: ");
		str = scanner.nextLine();

		scanner.close();

		int count = 0; // count la mot bien
		for (int i = 0; i < str.length(); i++) {
			if ('a' == str.charAt(i)) {
				count++; // neu co chua 'a' dem, sau moi vong for se cong dan cho count
			}
		}
		System.out.println(count);
	}

//		Question 12 (Optional): Reverse String
//		Đảo ngược chuỗi sử dụng vòng lặp
	// nhap vao 1 chuoi va chuan hoa
	public static void Question_4_12() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ba nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		str = str.replaceAll("\\s+", " ");
		String reverseStr = "";
		// dao nguoc chuoi
		for (int i = str.length() - 1; i >= 0; i--) {
			reverseStr += str.substring(i, i + 1);
		}
		System.out.println("Chuoi dao nguoc la:  " + reverseStr);
	}

//		Question 13 (Optional): String not contains digit
//		Kiểm tra một chuỗi có chứa số hay không, nếu có in ra false ngược
//		lại true.
//		Ví dụ:
//		"abc" => true
//		"1abc", "abc1", "123", "a1bc", null => false
	public static void Question_4_13() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi : ");
		String str = scanner.nextLine();
		boolean string = false;

// Character.isDigit: neu co so thi la true va nguoc lai false
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)) == true) {
				string = true;
				break;
			}
		}
		if (string == true) {
			System.out.println("Chuoi nay sai. nhap lai");
		} else {
			System.out.println(str);

		}

	}

//	Question 14 (Optional): Replace character
//	Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
//	cho trước.
//	Ví dụ:
//	"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
	public static void Question_4_14() {
		Scanner scanner = new Scanner(System.in);
		// nhap gia tri chuoi va ky tu
		System.out.println("Moi ba nhap vao 1 chuoi: ");
		String str = scanner.nextLine();

		System.out.println("Ky tu muon thay the: ");
		char ch1 = scanner.nextLine().toCharArray()[0]; // ch1 chi co 1 chu so

		System.out.println("Ky tu moi duoc thay the: ");
		char ch2 = scanner.nextLine().toCharArray()[0];
		// thay the ch2 cho ch1
		for (int i = 0; i < str.length(); i++) {
			str = str.replace(ch1, ch2);
		}
		System.out.println("Chuoi sau khi thay the la: " + str);
	}

//	Question 15 (Optional): Revert string by word
//	Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
//	thư viện.
//	Ví dụ: " I am developer " => "developer am I".
//	Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//	Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
//	chuỗi theo dấu cách

	public static void Question_4_15() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao 1 chuoi: ");
		String str = scanner.nextLine();
		str = str.replaceAll("\\s+", " ");
		// cat chuoi bang split
		String[] words = str.split(" ");
		str = "";
		for (int i = words.length - 1; i >= 0; i--) {
			str += words[i] + " ";
		}
		System.out.println("Chuoi dao nguoc la: " + str);

	}
//	Question 16 (Optional):
//		Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//		bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
//		hình “KO”.

	public static void Question_4_16() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao mot chuoi: ");
		String str = scanner.nextLine();
		System.out.println("so ky tu muon split ra: ");
		int n = scanner.nextInt();

		if (str.length() <= n) { // str.length <= n
			System.out.println(str);
		} else { // str.length > n
			if (str.length() % n != 0) {
				System.out.println("KO");
			} else {
				System.out.println("Tao thanh cong!");
				System.out.println("Cac chuoi ki tu sau khi cat: ");
				for (int i = 0; i < str.length(); i += n) {
					System.out.println(str.substring(i, i + n));
				}
			}
		}
	}

}

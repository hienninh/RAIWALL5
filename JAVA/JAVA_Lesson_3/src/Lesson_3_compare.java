
public class Lesson_3_compare {

public static void main(String[] args) {
	Exam_Compare();}
public static void Exam_Compare() {
	String x = "abc";
	String y = "bc";
	String z = "abc";
	String z1 = new String("abc");
	// hashCode
	System.out.println(x.hashCode());
	System.out.println(y.hashCode());
	System.out.println(z1.hashCode());
	System.out.println();
	// String Compare: equals
	System.out.println(x == y);
	System.out.println(x.equals(y));

	System.out.println(x == z);
	System.out.println(x.equals(z));

	System.out.println(x == z1);
	System.out.println(x.equals(z1));
	System.out.println();
	
	// toString: object convert ra string
	Department saleDepartment = new Department();
	saleDepartment.id = 1;
	saleDepartment.name = "sale";
	System.out.println(saleDepartment);
	
	// Compare object voi string: equals
	
	Account_3 namAccount = new Account_3();
	namAccount.id = 3;
	namAccount.email = "nguyennam@";
	System.out.println(namAccount.email.equals("nguyennam@")); // so sanh chuoi voi chuoi 
//	System.out.println(namAccount.equals("nguyeNam")); // so sanh object voi chuoi
	
	// Copare objec voi object: equals
	Account_3 nuAccount = new Account_3();
	nuAccount.id = 3;
	nuAccount.email = "nguyennam@";
	System.out.println(namAccount.equals(nuAccount));
	
}
}

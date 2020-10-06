import java.time.LocalDate;

public class Account_3 {
	int id;
	String email;
	String userName;
	String fullName;
	Department department;
	Position position;
	LocalDate createDate;
	Group[] groups;

	@Override
	public boolean equals(Object result) {
		if (result == null) {
			return false;
		}

//		String Email = result.toString(); // convert result sang string
//		if (email.equals(Email)) {
//			return true;
//		}
//		return false;
		Account_3 accounts = (Account_3) result;
		String Email = accounts.email;
		if (Email.equals(email)) {
			return true;
		}
		return false;
	}

}

import java.time.LocalDate;

public class Account {
	int id;
	String email;
	String userName;
	String fullName;
	Department department;
	Position position;
	LocalDate createDate;
	Group[] groups;
	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "email: " + email + "\n";
		result += "userName: " + userName + "\n";
		result += "department: " + department.name + "\n";
		result += "Position: " + position.name + "\n";
		
		return result;
	}
}

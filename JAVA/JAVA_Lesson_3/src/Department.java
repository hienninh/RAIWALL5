public class Department {
	byte id;
	String name;

	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "name: " + name + "\n";
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Department marketingDepartment = (Department) obj; // Department marketing (NEW) thanh  obj
		String Name = marketingDepartment.name; // Name : cua obj
		if (Name.equals(name)) {
			return true;}
		return false;
	}
}

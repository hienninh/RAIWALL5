package com.vti.backend;
import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Ex1_Constructor {

	public static void main(String[] args) {
//		Question_1_1();
		Question_1_2();
//		Question_1_3();
	}

	public static void Question_1_1() {
//		Question 1:
//		Tạo constructor cho department:
//		a) không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên

		// a: Khong co Parameters
		Department department = new Department();
		System.out.println(department);
		// b: co parameters: name, default id = 0
		Department department1 = new Department(0, "Nguyen Thi Dinh");
		System.out.println(department1);
	}

//			Question 2:
//			Tạo constructor cho Account:
//			a) Không có parameters
//			b) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName)
//			c) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName) và
//			Position của User, default createDate = now
//			d) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName) và
//			Position của User, createDate
//			Khởi tạo 1 Object với mỗi constructor ở trên
	public static void Question_1_2() {
		// a, khong co parameters
		Account account = new Account();
		
		// b, co parameters: id, email, userName, fisrtName, lastName
		Account account1 = new Account(1, "nguyen@gmail.com", "Nguyenminh", "Nguyen", "Minh");
		System.out.println(account1);
		
		/// 
		
		Position position = new Position((short) 3, PositionName.DEV);
	
		String email = "le@gmail.com";
		LocalDate cearteDate = LocalDate.of(2019, 12, 01);

		Account account2 = new Account(0, email, "Lenguyen", "nguyen", "le", position, cearteDate);
		// c, co parameters: id, email, userName, fisrtName, lastName, position,
		// createdate la now

		Account account3 = new Account(0, email, "leNam", "nguyen", "Le Nam", position, LocalDate.now());
	}

//			Question 3:
//			Tạo constructor cho Group:
//			a) không có parameters
//			b) Có các parameter là GroupName, Creator, array Account[]
//			accounts, CreateDate
//			c) Có các parameter là GroupName, Creator, array String[]
//			usernames , CreateDate
//			Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
//			username, các thông tin còn lại = null).
//			Khởi tạo 1 Object với mỗi constructor ở trên
	
	public static void Question_1_3() {
		// a, không có parameters
		Group group = new Group();
		
		//b, Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
		// creator
		Account creator = new Account((short) 6, "nguyenlong@gmail", "nguyenlong", null, null, null, null);
		
		// tao array accounts
		Account account1 = new Account();
		
		Account account2 = new Account();
	
		Account account3 = new Account();
		
		Account[] accounts = {account1, account2, account3};

		// tao localdate
		LocalDate cearteDate = LocalDate.of(2020, 01, 01);
		
		Group group1 = new Group("hoc gioi", creator, accounts, cearteDate);
		
	//	c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate (Chua bai tap)
		// tao array string
		
		String[] userNames = {"Ninh Hien", "Ninh Hien2", "Ninh Hien3"};
		LocalDate cearteDate1 = LocalDate.of(2020, 12, 01);
		Group group2 = new Group("NinhHien", creator, userNames, cearteDate1);
		
	}
	
}

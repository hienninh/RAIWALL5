package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.Controller.UserController;
import com.vti.entity.User;

public class Program {
	private static UserController controller;
	private static User user;
	

	public Program() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		user = new User();
	}
	public static void main(String[] args) throws Exception {
		controller = new UserController();
		getListUsers();
//		getUserByID();
//		deleteUser();
	}

	// get list User
	@SuppressWarnings("unused")
	private static void getListUsers() throws SQLException, ClassNotFoundException, IOException {
		List<User> users = controller.getListUser();
		System.out.printf("%-30s %-50s %s \n", "id", "email", "fullname");
		for (User user : users) {
			System.out.printf("%-30s %-50s %s \n" , user.getId(),user.getEmail(), user.getFullName());
		}
		
	}

	// get User By Id
	@SuppressWarnings("unused")
	private static void getUserByID() throws SQLException, Exception {
		System.out.print("Moi nhap vao id: ");
		int id = ScannerUtils.intpositive("Ban phai nhap vao so nguyen: ");
		User user = controller.getUserById(id);
		System.out.println(user);
	}

	//
	@SuppressWarnings("unused")
	private static void deleteUser() throws Exception {
		System.out.print("Moi ban nhap vao ID: ");
		int id = ScannerUtils.intpositive("Ban phai nhap so nguyen duong ");
		controller.DeleteUser(id);
	}
}

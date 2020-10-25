package com.vti.backend.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.Service.UserService;
import com.vti.entity.User;

public class UserController {
	private UserService services;

	public UserController() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		services = new UserService();
	}

	//getListUsers
	public List<User> getListUser() throws SQLException {
		return services.getListUser();
	}

	// getUserById
	public User getUserById(int ID) throws Exception {
		return services.getUserById(ID);
	}

	// DeleteUser
	public void DeleteUser(int ID) throws SQLException {
		services.DeleteUser(ID);
	}
}

package com.vti.backend.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.Repository.QLUser;
import com.vti.entity.User;

/**
 * This class is : Service of student
 * 
 * @Description: .
 * @author: NinhHien
 * @create_date: Oct 24, 2020
 * @version: 2.0
 * @modifer: NinhHien
 * @modifer_date: Oct 24, 2020
 */
public class UserService {
	private QLUser qluser;

	public UserService() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		qluser = new QLUser();
	}

	// getListUsers
	public List<User> getListUser() throws SQLException {
		return qluser.getListUser();
	}

	// getUserById
	public User getUserById(int ID) throws Exception {
		return qluser.getUserById(ID);
	}

	// DeleteUser
	public void DeleteUser(int ID) throws SQLException {
		qluser.DeleteUser(ID);
	}
}

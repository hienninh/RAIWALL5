package com.vti.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.repository.IQLUser;
import com.vti.backend.repository.QLUser;
import com.vti.entity.Employee;
import com.vti.entity.Manager;

public class service implements IQLUser {
	private static QLUser qluser;

	public service() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		qluser = new QLUser();}

	public Employee getEmployeeById(int id) throws Exception {
		return qluser.getEmployeeById(id);
	}
	
	@Override
	public Manager getManagerById(int id) throws Exception {
			return qluser.getManagerById(id);
		}
	@Override
	public List<Manager> getListManagers() throws SQLException {
		return qluser.getListManagers();
	}

	
}

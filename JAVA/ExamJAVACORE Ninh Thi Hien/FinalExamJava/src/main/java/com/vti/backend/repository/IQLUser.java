package com.vti.backend.repository;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;

public interface IQLUser {
	public Employee getEmployeeById(int id) throws Exception;

	public Manager getManagerById(int id) throws Exception;

	public List<Manager> getListManagers() throws SQLException;
}

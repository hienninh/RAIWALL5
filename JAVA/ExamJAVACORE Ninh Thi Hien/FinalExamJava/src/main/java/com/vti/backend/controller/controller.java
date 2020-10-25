package com.vti.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.service.Iservice;
import com.vti.backend.service.service;
import com.vti.entity.Employee;
import com.vti.entity.Manager;

public class controller implements Iservice {

	private static service services;

	public controller() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		services = new service();}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		return services.getEmployeeById(id);
	}
	@Override
	public Manager getManagerById(int id) throws Exception {
			return services.getManagerById(id);
		}
	@Override
	public List<Manager> getListManagers() throws SQLException {
		return services.getListManagers();
	}

}

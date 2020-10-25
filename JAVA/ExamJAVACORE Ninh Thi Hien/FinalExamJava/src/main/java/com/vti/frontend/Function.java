package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.controller.controller;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class Function {
	private static Employee employee;
	private static Manager manager;
	private static controller control;

	public Function() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		employee = new Employee();
		control = new controller();
	}

	/**
	 * This method is . lay thong tin employee bo project_ID
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @throws SQLException
	 * @throws Exception
	 */
	public static void getEmployeeById() throws SQLException, Exception {
		System.out.print("Moi nhap vao id: ");
		int id = com.vti.utils.ScannerUtils.intpositive("Ban phai nhap vao so nguyen, Moi nhap lai!");
		Employee employee = control.getEmployeeById(id);
		System.out.printf("%-30s %-50s %s \n", "idEmployees", "FullName", "Email", "Password", "projectId", "ProSkill");
		System.out.printf("%-30s %-50s %s \n", employee.getId(), employee.getFullName(), employee.getEmail(),
				employee.getPassword(), employee.getProjectId(), employee.getProSkill());
	}

//
	public static void getManagerById() throws Exception {
		System.out.print("Moi nhap vao id: ");
		int id = com.vti.utils.ScannerUtils.intpositive("Ban phai nhap vao so nguyen, Moi nhap lai!");
		Manager manager = control.getManagerById(id);
		System.out.printf("%-30s %-50s %s \n", "idManager", "FullName", "Email", "Password", "ExpInYear");
		System.out.printf("%-30s %-50s %s \n", manager.getId(), manager.getFullName(), manager.getEmail(),
				manager.getPassword(), manager.getExpInYear());
	}

	/**
	 * This method is . lay toan bo thong tin cua Manager
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void getListManagers() throws SQLException, ClassNotFoundException, IOException {
		List<Manager> managers = control.getListManagers();
		System.out.printf("%-30s %-50s %s \n", "idManager", "FullName", "Email", "Password", "ExpInYear");
		for (Manager manager : managers) {
			System.out.printf("%-30s %-50s %s \n", manager.getId(), manager.getFullName(), manager.getEmail(),
					manager.getPassword(), manager.getExpInYear());
		}
	}

}

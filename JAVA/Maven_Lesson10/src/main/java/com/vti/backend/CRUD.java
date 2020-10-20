package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.vti.entity.JdbcUtils;
import com.vti.entity.ScannerUtils;

public class CRUD {
	static JdbcUtils jdbcUtils;
	static Connection connection;

	public CRUD() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.Connect();
	}

//Question 1
	public void getDepartment() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		// Step3: Create a statement obj
		Statement statement = connection.createStatement();

		// Step4: Execute SQL query
		String sql = "SELECT * FROM department";
		ResultSet resultset = statement.executeQuery(sql);

		// Step5: Print
		while (resultset.next()) {
			int ID = resultset.getInt("DEPARTMENT_ID");
			String Name = resultset.getString("DEPARTMENT_NAME");
			System.out.println("Id: " + ID);
			System.out.println("Name: " + Name);
		}
		// step: close
		connection.close();
	}

	// Question 2
	public void getDepartmentById5() throws Exception {
		// Step 3: create statement obj
		String sql = "SELECT * FROM department WHERE DEPARTMENT_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input from scanner
		int DepartmentId = 5;
		// set prameter
		preparedStatement.setInt(1, DepartmentId);
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step5: Print
		if (resultSet.next()) {
			System.out.println(resultSet.getInt("DEPARTMENT_ID"));
			System.out.println(resultSet.getString("DEPARTMENT_NAME"));
		} else {
			throw new Exception("Cannot find department which has id = 5");
		}
	}

//Question3: Su dung scanner.util
	public void getDepartmentById() throws Exception {
		String sql = "SELECT * FROM department WHERE DEPARTMENT_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input from scanner
		System.out.print("Moi ban nhap vao 1 so nguyen: ");
		int DepartmentId = ScannerUtils.intpositive("Ban phai nhap vao so duong ");
		// set prameter
		preparedStatement.setInt(1, DepartmentId);
		ResultSet resultSet = preparedStatement.executeQuery();
		// Step5: Print
		if (resultSet.next()) {
			System.out.println(resultSet.getInt("DEPARTMENT_ID"));
			System.out.println(resultSet.getString("DEPARTMENT_NAME"));
		} else {
			throw new Exception("Cannot find department " + DepartmentId);
		}
	}

//Question 4: check data exists – check department name exists
	public boolean isDepartmentNameExists(String name) throws Exception {
		String sql = "SELECT * FROM department WHERE DEPARTMENT_NAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set prameter
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		// Step5: Print
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	// Question 5: create data – create department
	public void createDepartment(String Name) throws Exception {
		// if exist
		if (isDepartmentNameExists(Name)) {
			throw new Exception("Department Name is exist");
		}
		// if not exist
		String sql = "INSERT INTO Department	(DEPARTMENT_NAME) \r\n" + "VALUES	( ?	)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set prameter
		preparedStatement.setString(1, Name);
		//Excute SQL query
		int rowAffectAmounts = preparedStatement.executeUpdate();
		System.out.println("So dong bi anh huong: " + rowAffectAmounts);
	}
	//Question 6: update data – update department
}

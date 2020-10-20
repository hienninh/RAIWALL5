package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.vti.entity.Position;
import com.vti.entity.ScannerUtils;

public class Program {
	public static void Demo() throws ClassNotFoundException, SQLException {
//	 Step 1: Setup library
//	 Step 2: Get a connection to database
		String url = "jdbc:mysql://localhost:3306/TestingSystem?autoReconnect=true&useSSL=false&characterEncoding=latin1&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
//	 Step 3: Create a statement object
		Statement statement = connection.createStatement();
		String sql = "SELECT * From Question_Level";
//	 Step 4: Execute SQL query
		ResultSet resultset = statement.executeQuery(sql);
//	 Step 5: Handling Result Set: xử lý
		while (resultset.next()) {
			int ID = resultset.getInt("id");
			String Level = resultset.getString("level");
			System.out.println("ID: " + ID);
			System.out.println("Level: " + Level);
		}
//	 Step 6: Close connection
		connection.close();
	}

//Question 1: (Sử dụng Database Testing System đã xây dựng ở SQL)
//	Tạo connection tới database Testing System
//	In ra "Connect success!" khi kết nối thành công.
	public void Question1() throws ClassNotFoundException, SQLException {
		Demo();
		System.out.println("Connect success!");
	}

//	Question 2:
//	Tạo method để in ra các thông tin của position gồm có id, name
	public void Question2() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/TESTING_SYSTEM_ASSIGNMENT_1?autoReconnect=true&useSSL=false&characterEncoding=latin1&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
//	 Step 3: Create a statement object
		Statement statement = connection.createStatement();
		String sql = "SELECT * From POSITION";
//	 Step 4: Execute SQL query
		ResultSet resultset = statement.executeQuery(sql);
//	 Step 5: Handling Result Set: xử lý
		while (resultset.next()) {
			int ID = resultset.getInt("POSITION_ID");
			String name = resultset.getString("POSITION_NAME");
			System.out.println("Id: " + ID);
			System.out.println("Name: " + name);
		}
//	 Step 6: Close connection
		connection.close();
	}

	// Question3
	public static void Question3() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/TESTING_SYSTEM_ASSIGNMENT_1?autoReconnect=true&useSSL=false&characterEncoding=latin1&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
//	 Step 3: Create a statement object
		Statement statement = connection.createStatement();
		String sql = "INSERT INTO Position	(POSITION_NAME	)" + "  VALUES	( ?)"; // la gi tri ng dung nhap vao
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input positionName
		System.out.println("Moi nhap vao ten: ");
		String positionName = ScannerUtils.inputString();
		preparedStatement.setString(1, positionName);

		// Step 4: Execute SQL query
		int rowAffectedAmount = preparedStatement.executeUpdate();
		System.out.println(rowAffectedAmount);
		System.out.println("Insert scusseefully");
		// Step 6: Close connection
		connection.close();
	}

	// Question 4: Tạo method để update tên của position gồm có id = 5 thành "Dev".
	public static void Question4() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/TESTING_SYSTEM_ASSIGNMENT_1?autoReconnect=true&useSSL=false&characterEncoding=latin1&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username = "root";
		String password = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		//	Step 3: Create a statement object
		Statement statement = connection.createStatement();
		String sql = "UPDATE Position " 
					+ "Set POSITION_NAME = 'DeV' " 
					+ "WHERE POSITION_ID = 5 ";

		// Step 4: Execute SQL query
		int rowAffectedAmount = statement.executeUpdate(sql);
		System.out.println(rowAffectedAmount);
		System.out.println("Update scusseefully");
		// Step 6: Close connection
		connection.close();
	}
	//Question 5: Tạo method để delete của position theo id và user sẽ nhập vào id
	
}

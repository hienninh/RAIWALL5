package com.vti.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	static Properties properties;
	static Connection connection;

	// Question 1: Tạo method để test xem đã kết nối thành công tới sql chưa?
	public Connection Connect() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (connection != null) {
			return connection;
		}

		properties = new Properties();
		properties.load(new FileInputStream("src\\main\\resource\\database.properties"));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success! ");

		return connection;
	}

	// Question 2: Tạo method để get Connect tới database.
	public void isConnectedForTesting() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream("src\\main\\resource\\database.properties"));
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		// Step 1: register the driver class with DriverManager
		Class.forName(properties.getProperty("driver"));
		// Step 2: get a Database Connection
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success! ");
	}

	// Question3: Tạo method để get disconnect tới database
	public void disconnect() throws SQLException {
		connection.close();

	}
}

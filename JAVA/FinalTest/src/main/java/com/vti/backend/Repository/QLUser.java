package com.vti.backend.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.vti.Utils.JdbcUtils;
import com.vti.entity.User;

public class QLUser {
	private Connection connection;
	private User user;
	private JdbcUtils jdbcUtils;

	/**
	 * Constructor for class QLUser.
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 24, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 24, 2020
	 * @param user
	 * @throws IOException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public QLUser() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		user = new User();
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.connect();
	}

//getListUsers
	public List<User> getListUser() throws SQLException {
		List<User> users = new ArrayList<>();
		try {
			//// Step 3: Create a statement object
			Statement statement = connection.createStatement();

			// Step4: Execute SQL query
			String sql = "SELECT * " + "FROM `User` ";
			ResultSet resultset = statement.executeQuery(sql);
			
			// Step5: Handling result set
			while (resultset.next()) {
				User user = new User(resultset.getInt("id"), resultset.getString("FullName"),
						resultset.getString("Email"),resultset.getString("Password"));
				users.add(user);
			}
		} finally {
			jdbcUtils.disconnect();
		}
		return users;
	}

	// getUserById
	public User getUserById(int ID) throws Exception {
		// Step 4: Execute SQL query
		String sql = "SELECT *" + "FROM `User` " + "WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// Step4: input from scanner
		// Step5: Set prameter
		preparedStatement.setInt(1, ID);
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step6: Handling result Set
		if (resultSet.next()) {
			User user = new User(resultSet.getInt("id"), resultSet.getString("FullName"), resultSet.getString("Email"),
					resultSet.getString("Password"));
			return user;
		} else {
			throw new Exception("Cannot find Account " + ID);
		}
	}

	// DeleteUser
	public void DeleteUser(int ID) throws SQLException {
		// if exist
		String sql = "DELETE\r\n " + "From `User` \r\n " + "WHERE id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input name
		// set prameter
		preparedStatement.setInt(1, ID);
		// Excute SQL query
		int rowAffectAmount = preparedStatement.executeUpdate();
		System.out.println(rowAffectAmount > 0 ? "Delete success !" : "Delete fail!");
	}
}

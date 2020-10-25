package com.vti.backend.datalayer;

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
import com.vti.entity.Account;

/**
 * This class is : AccountRepository
 * 
 * @Description: .
 * @author: NinhHien
 * @create_date: Oct 23, 2020
 * @version: 2.0
 * @modifer: NinhHien
 * @modifer_date: Oct 23, 2020
 */

public class AccountRepository implements IAccountRepository {
	static JdbcUtils jdbcUtils;
	static Properties properties;
	static Connection connection;

	public AccountRepository() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.connect();
	}

	/*
	 * @see com.vti.backend.datalayer.IAccountRepository#getListAccounts()
	 */
	@Override
	public List<Account> getListAccounts() throws SQLException {
		List<Account> accounts = new ArrayList<>();
		try {
			// get connect
			//// Step 3: Create a statement object
			Statement statement = connection.createStatement();

			// Step4: Execute SQL query
			String sql = "SELECT ACCOUNT_ID, USER_NAME, FULL_NAME, EMAIL\r\n" + "FROM `Account`";
			ResultSet resultset = statement.executeQuery(sql);

			// Step5: Handling result set
			while (resultset.next()) {
				Account account = new Account( resultset.getInt("ACCOUNT_ID"),resultset.getString("EMAIL"),
						resultset.getString("USER_NAME"), resultset.getString("FULL_NAME"));
				accounts.add(account);
			}
		} finally {
			jdbcUtils.disconnect();
		}
		return accounts;
	}

	/*
	 * @see com.vti.backend.datalayer.IAccountRepository#getAccountByID(int)
	 */
	@Override
	public Account getAccountByID(int id) throws Exception {
		// get connect
		// Step 3: Create a statement object
		// Step 4: Execute SQL query
		String sql = "SELECT ACCOUNT_ID, USER_NAME, FULL_NAME, EMAIL\r\n" + "FROM `Account`\r\n"
				+ "Where ACCOUNT_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// Step4: input from scanner
		// Step5: Set prameter
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step6: Handling result Set
		if (resultSet.next()) {
			Account account = new Account(resultSet.getInt("ACCOUNT_ID"),resultSet.getString("EMAIL"),
					resultSet.getString("USER_NAME"), resultSet.getString("FULL_NAME"));
			return account;
		} else {
			throw new Exception("Cannot find Account " + id);
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IAccountRepository#isAccountExists(java.lang.
	 * String)
	 */
	@Override
	public boolean isAccountExists(String username) throws SQLException {
		// get connect
		// Step 3: Create a statement object
		// Step4: Execute SQL query
		String sql = "SELECT ACCOUNT_ID, USER_NAME, FULL_NAME, EMAIL " + " FROM `Account`" + " Where USER_NAME = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input name
		// set prameter
		preparedStatement.setString(1, username);
		ResultSet resultSet = preparedStatement.executeQuery();
		// Step5: Print
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @see com.vti.backend.datalayer.IAccountRepository#isAccountExists(int)
	 */
	@Override
	public boolean isAccountExists(int id) throws SQLException {
		String sql = "SELECT ACCOUNT_ID, USER_NAME, FULL_NAME, EMAIL " + "FROM `Account` " + "Where ACCOUNT_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input name
		// set prameter
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		// Step5: Print
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @see
	 * com.vti.backend.datalayer.IAccountRepository#createAccount(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void createAccount(String email, String userName, String fullName) throws Exception {
		// Account is exist
		if (isAccountExists(userName) == true) {
			throw new Exception("Account is exist!");
		}
		// Account is not exist
		// if not exist
		String sql = "INSERT INTO `Account`(Email	, USER_NAME	, FULL_NAME	)	\r\n"
				+ "VALUES 					(?		,?			,?			)	";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input name
		// set prameter
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, userName);
		preparedStatement.setString(3, fullName);

		// Excute SQL query
		preparedStatement.executeUpdate();
		System.out.println("Create success!");
	}

	/*
	 * @see com.vti.backend.datalayer.IAccountRepository#updateAccountByID(int,
	 * java.lang.String)
	 */
	@Override
	public void updateAccountByID(int id, String newUserName) throws Exception {
		// if exist
		if (!isAccountExists(id)) { // ID khong ton tai
			throw new Exception("Cannot find Account which has id = " + id);
		} else if (isAccountExists(newUserName)) { // Id co ton tai va Name da ton tai. Sai tại đây nhé, chị xem fix nha :)) 
			throw new Exception("Account Name is exist");
		}
		// ID ton tai va Name khong ton tai
		// Step4: Execute SQL query
		String sql = "Update `Account` " + "Set	USER_NAME = ? " + "WHERE ACCOUNT_ID = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input name
		// set prameter
		preparedStatement.setString(1, newUserName);
		preparedStatement.setInt(2, id);
		// Excute SQL query
		preparedStatement.executeUpdate();
		System.out.println("Update success!");
	}

	/*
	 * @see com.vti.backend.datalayer.IAccountRepository#deleteAccount(int)
	 */
	@Override
	public void deleteAccount(int id) throws Exception {
		// if not exist
		if (!isAccountExists(id)) { // ID khong ton tai
			throw new Exception("Cannot find Acount which has id = " + id);
		}
		// if exist
		String sql = "DELETE\r\n " + "From `Account` \r\n " + "WHERE ACCOUNT_ID = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// input name
		// set prameter
		preparedStatement.setInt(1, id);
		// Excute SQL query
		preparedStatement.executeUpdate();
		System.out.println("Delete success!");
	}
}

package com.vti.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.utils.JdbcUtils;

public class QLUser {
	private Connection connection;
	private Employee employee;
	private Manager manager;
	private JdbcUtils jdbcUtils;

	public QLUser() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		employee = new Employee();
		manager = new Manager();
		jdbcUtils = new JdbcUtils();
		connection = jdbcUtils.connect();
	}

	/**
	 * This method is . nhập vào id project, sau đó in ra tất cả các employee
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @param id
	 * @return
	 * @throws Exception
	 */
	//get empolye boi project_ID
	public Employee getEmployeeById(int id) throws Exception {
		// Step 4: Execute SQL query
		String sql = "SELECT E.idEmployees, FullName, Email, `Password`,   P.projectId, ProSkill\r\n"
				+ " FROM 	Employee E\r\n"
				+ " JOIN		Project P ON	P.idEmployees = E.idEmployees\r\n"
				+ " WHERE P.projectId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// Step4: input from scanner
		// Step5: Set prameter
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step6: Handling result Set
		if (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("E.idEmployees"), resultSet.getString("FullName"),
					resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("P.projectId"),
					resultSet.getString("ProSkill"));
			return employee;
		} else {
			throw new Exception("Cannot find Emplyee " + id);
		}
	}
	
	/**
	 * This method is . get Manager by project_ID
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Manager getManagerById(int id) throws Exception {
	// Step 4: Execute SQL query
			String sql = " SELECT M.idManager, FullName, Email, `Password`, ExpInYear, ExpInYear\r\n"
					+ " FROM 	Manager M\r\n"
					+ " JOIN		Project P ON	P.idManager = M.idManager\r\n"
					+ " WHERE P.projectId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Step4: input from scanner
			// Step5: Set prameter
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step6: Handling result Set
			if (resultSet.next()) {
				Manager manager = new Manager(resultSet.getInt("idManager"), resultSet.getString("FullName"),
						resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("ExpInYear"));
				return manager;
			} else {
				throw new Exception("Cannot find Manager " + id);
			}
}
	/**
	 * This method is . lấy ra tất cả Manager của các project
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @return
	 * @throws SQLException
	 */
	public List<Manager> getListManagers() throws SQLException {
		List<Manager> managers = new ArrayList<>();
		try {
			//// Step 3: Create a statement object
			Statement statement = connection.createStatement();

			// Step4: Execute SQL query
			String sql = " SELECT M.idManager, FullName, Email, `Password`, ExpInYear, P.projectId\r\n"
					+ " FROM 	Manager M\r\n"
					+ " JOIN		Project P ON	P.idManager = M.idManager ";
			ResultSet resultset = statement.executeQuery(sql);

			// Step5: Handling result set
			while (resultset.next()) {
				Manager manager = new Manager(resultset.getInt("idManager"), resultset.getString("FullName"),
						resultset.getString("Email"), resultset.getString("Password"), resultset.getInt("ExpInYear"));
				managers.add(manager);
			}
		} finally {
			jdbcUtils.disconnect();
		}
		return managers;
	}

	/**
	 * This method is . User sẽ nhập Email và Password trên giao diện login Chương
	 * trình
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 25, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 25, 2020
	 * @param Email
	 * @param Password
	 * @throws SQLException
	 */
	public void loginUser(String Email, String Password) throws SQLException {
		// Step 3: Create a statement object

		String sql = "SELECT * FROM usermanager.user " + "WHERE Email = ? AND Password = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, Email);
		preparedStatement.setString(2, Password);

		// Step 4: Execute Query

		ResultSet resultSet = preparedStatement.executeQuery();

	}
}

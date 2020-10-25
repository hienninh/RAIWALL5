package com.vti.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;

public interface IAccountController {
	public List<Account> getListAccounts() throws SQLException, ClassNotFoundException, IOException;

	public Account getAccountByID(int id) throws SQLException, Exception;

	public boolean isAccountExists(String username) throws SQLException, Exception;

	public boolean isAccountExists(int id) throws SQLException;
	
	public void createAccount(String email, String userName,String fullName) throws Exception;

	public void updateAccountByID(int id, String newUserName) throws Exception;

	public void deleteAccount(int id) throws Exception;

}

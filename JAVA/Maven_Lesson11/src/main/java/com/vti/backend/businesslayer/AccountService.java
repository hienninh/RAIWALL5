package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.backend.datalayer.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Group;

/**
 * This class is :  Service of Account
 * 
 * @Description: .
 * @author: NinhHien
 * @create_date: Oct 23, 2020
 * @version: 2.0
 * @modifer: NinhHien
 * @modifer_date: Oct 23, 2020
 */
public class AccountService implements IAccountService {
	private IAccountRepository Repository;

	public AccountService() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Repository = new AccountRepository();
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#getListAccounts()
	*/
	public List<Account> getListAccounts() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		return Repository.getListAccounts();
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#getAccountByID(int)
	*/
	@Override
	public Account getAccountByID(int id) throws SQLException, Exception {
		return Repository.getAccountByID(id);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#isAccountExists(java.lang.String)
	*/
	@Override
	public boolean isAccountExists(String username) throws SQLException {
		return Repository.isAccountExists(username);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#isAccountExists(int)
	*/
	@Override
	public boolean isAccountExists(int id) throws SQLException {
		return Repository.isAccountExists(id);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#createAccount(java.lang.String, java.lang.String, java.lang.String)
	*/
	@Override
	public void createAccount(String email, String userName, String fullName) throws Exception {
		
		Repository.createAccount(email, userName, fullName);
	}
	
	/* 
	* @see com.vti.backend.businesslayer.IAccountService#updateAccountByID(int, java.lang.String)
	*/
	public void updateAccountByID(int id, String newUserName) throws Exception {
		Repository.updateAccountByID(id, newUserName);
	}

	/* 
	* @see com.vti.backend.businesslayer.IAccountService#deleteAccount(int)
	*/
	@Override
	public void deleteAccount(int id) throws Exception {
		Repository.deleteAccount(id);
	}

}

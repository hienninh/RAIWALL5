package com.vti.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.AccountService;
import com.vti.backend.businesslayer.IAccountService;
import com.vti.entity.Account;
import com.vti.entity.Group;

/**
 * This class is : Controller of Account
 * 
 * @Description: .
 * @author: NinhHien
 * @create_date: Oct 23, 2020
 * @version: 2.0
 * @modifer: NinhHien
 * @modifer_date: Oct 23, 2020
 */
public class AccountController implements IAccountController {
	private IAccountService Service;

	public AccountController() throws ClassNotFoundException, SQLException, IOException {
		Service = new AccountService();
	}

//getListAccounts
	public List<Account> getListAccounts() throws ClassNotFoundException, SQLException, IOException {
		return Service.getListAccounts();
	}

//getAccountByID =?
	@Override
	public Account getAccountByID(int id) throws Exception {
		if (!Service.isAccountExists(id)) {
			throw new Exception("Account is not exist!");
		}
		return Service.getAccountByID(id);
	}

//isAccountExists username = ?
	@Override
	public boolean isAccountExists(String username) throws Exception {
		// VAlidation
		if (username == null || username.length() > 30 || username.length() < 6) {
			throw new Exception("Length Usename dont must lager than 30 or less than 6");
		}
		return Service.isAccountExists(username);
	}

//isAccountExists id =?
	@Override
	public boolean isAccountExists(int id) throws SQLException {
		return Service.isAccountExists(id);
	}

//createAccount
	@Override
	public void createAccount(String email, String userName, String fullName) throws Exception {
		// validation
		if (userName == null || userName.length() > 30 || userName.length() < 1) {
			throw new Exception("Usename dont must lager than 30 or less than 1");
		}
		Service.createAccount(email, userName, fullName);
	}

//	updateAccountByID = ?
	@Override
	public void updateAccountByID(int id, String newUserName) throws Exception {
		Service.updateAccountByID(id, newUserName);
	}

//deleteAccount , id = ?
	@Override
	public void deleteAccount(int id) throws Exception {
		Service.deleteAccount(id);
	}

}

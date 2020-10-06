package com.vti.entity;

import java.time.LocalDate;

public class Group {
	private short id;
	String name;
	Account creator;
	Account[] accounts;
	LocalDate createDate;

	// excersice 1_3
	public Group() {
	}

	public Group(String name, Account creator, Account[] accounts, LocalDate createDate) {
		this.name = name;
		this.accounts = accounts;
		this.creator = creator;
		this.createDate = createDate;
	}
// c) Có các parameter là GroupName, Creator, array String[]
//	usernames , CreateDate
	
	public Group(String name, Account creator, String[] userNames, LocalDate createDate) {
		this.name = name;
		this.creator = creator;
		this.createDate = createDate;
	// tao Account
		Account [] userAccount = new Account [userNames.length];
		for (int i = 0; i < userAccount.length; i++) {
			userAccount[i] =  new Account(userNames[i]);
		}
		
	}

	
	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


}

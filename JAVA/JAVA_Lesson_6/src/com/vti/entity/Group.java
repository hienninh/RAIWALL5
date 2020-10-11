package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

import com.vti.utils.ScannerUtils;

public class Group {
	private short id;
	private String name;
	private Account creator;
	private Account[] accounts;
	private LocalDate createDate;

	public Group() {
		ScannerUtils scanUtil = new ScannerUtils();
		System.out.println("");
	}

	public Group(String name, Account creator, Account[] accounts, LocalDate createDate) {
		this.name = name;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}
	// get, set

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
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
	// toString

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", accounts=" + Arrays.toString(accounts)
				+ ", createDate=" + createDate + ", getId()=" + getId() + ", getName()=" + getName() + ", getCreator()="
				+ getCreator() + ", getAccounts()=" + Arrays.toString(getAccounts()) + ", getCreateDate()="
				+ getCreateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}



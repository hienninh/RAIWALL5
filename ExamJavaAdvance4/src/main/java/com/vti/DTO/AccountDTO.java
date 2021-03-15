package com.vti.DTO;

import java.util.List;

import com.vti.entity.Account;

public class AccountDTO {
private short id;
private String fullname;
private List<String> groupName;


public AccountDTO(short id, String fullname, List<String> groupName) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.groupName = groupName;
}
public AccountDTO() {
	super();
}
public short getId() {
	return id;
}
public void setId(short id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}

public List<String> getGroupName() {
	return groupName;
}
public void setGroupName(List<String> groupName) {
	this.groupName = groupName;
}


@Override
public String toString() {
	return "AccountDTO [id=" + id + ", fullname=" + fullname + ", groupName=" + groupName + "]";
}
public Account toEntity() {
	return new Account();
	
}
}

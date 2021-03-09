package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.entity.Enum.UserStatus;

@Entity
@Table(name = "`User`")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false, unique= true)
private int id;

@Column(name = "`username`", nullable = false, length = 50, unique = true)
private String userName;

@Column(name = "`email`", nullable = false, length = 50, unique = true)
private String email;

@Column(name = "`password`", nullable = false, length = 800)
private String password;

@Enumerated(EnumType.ORDINAL)
@Column(name = "`status`", nullable = false)
private UserStatus status = UserStatus.NOT_ACTIVE;

public User(int id, String userName, String email, String password, UserStatus status) {
	this.id = id;
	this.userName = userName;
	this.email = email;
	this.password = password;
	this.status = status;
}

public User(String userName, String email, String password) {
	this.userName = userName;
	this.email = email;
	this.password = password;
}

public User() {
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public UserStatus getStatus() {
	return status;
}

public void setStatus(UserStatus status) {
	this.status = status;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}

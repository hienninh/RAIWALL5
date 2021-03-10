package com.vti.entity.DTO;

import com.vti.entity.User;

public class UserDTO {
	private String userName;

	private String email;

	private String password;

	public UserDTO(String userName, String email, String password) {

		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
	
	public User toEntity() {
		return new User(userName, email, password);
	}

}

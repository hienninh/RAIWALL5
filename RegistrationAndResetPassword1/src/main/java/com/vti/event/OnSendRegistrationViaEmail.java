package com.vti.event;

import org.springframework.context.ApplicationEvent;
//Sự kiện đăng ký thông qua email
public class OnSendRegistrationViaEmail extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	private String email;
	public OnSendRegistrationViaEmail(String email) {
		super(email);
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

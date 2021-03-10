package com.vti.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.vti.service.IEmailService;
@Component
// Nơi hứng/ xử lý sự kiện OnSendRegistrationViaEmail
public class SendRegistrationViaEmailListener implements ApplicationListener<OnSendRegistrationViaEmail> {
	@Autowired
	private IEmailService emailService;

	@Override
//	b2:
	public void onApplicationEvent(OnSendRegistrationViaEmail event) {
// event.getEmail() từ OnSendRegistrationViaEmail 
		sendConfirmViaEmail(event.getEmail());
	}

// b1: emailService gửi email confirm đến mail đăng ký
	private void sendConfirmViaEmail(String email) {
		emailService.sendRegistrationViaEmailListener(email);
	}

}

package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.vti.entity.User;
import com.vti.repository.IRegistrationUserTokenRepository;
import com.vti.repository.IUserRepository;

public class EmailService implements IEmailService {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRegistrationUserTokenRepository registrationUserTokenRepository;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendRegistrationViaEmailListener(String email) {
//		B1: get user by Email
		User user = userService.findUserByEmail(email);
//		B2: have user => get token of Registration_User_Token by user_id
		String token = registrationUserTokenRepository.findByUserId(user.getId());
		String confirmationUrl = "http://localhost:8080/api/v1/Users/activeUser?token=" + token;
		String subject = "Xác Nhận Đăng Ký Tài Khoản";
		;
		String content = "Bạn đã đăng ký thành công. Click vào link dưới đây để kích hoạt tài khoản \n"
				+ confirmationUrl;
		sendEmail(email, subject, content);

	}

	private void sendEmail(final String recipientEmail, final String subject, final String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject(subject);
		message.setText(content);

		mailSender.send(message);
	}

}

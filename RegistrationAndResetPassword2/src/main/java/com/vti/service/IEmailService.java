package com.vti.service;

public interface IEmailService {
// xử lý việc gửi email confirm đến email đã đăng ký 
	void sendRegistrationViaEmailListener(String email);

}

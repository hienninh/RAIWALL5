package com.vti.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vti.entity.RegistrationUserToken;
import com.vti.entity.User;
import com.vti.entity.Enum.UserStatus;
import com.vti.event.OnSendRegistrationViaEmail;
import com.vti.repository.IRegistrationUserTokenRepository;
import com.vti.repository.IUserRepository;

@Component
//  phòng trường hợp createUser thành công mà sendConfirmRegistrationViaEmail lỗi /... => Error 
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserRepository userRepository;
// event 
	@Autowired
	private ApplicationEventPublisher eventPublisher;
// Khai báo token
	@Autowired
	private IRegistrationUserTokenRepository registrationUserTokenRepository;

// Create user
	@Override
	public void createUser(User user) {
		userRepository.save(user);
//	b2: su dung, Create new RegistrationUserToken
		CreateNewRegistrationToken(user);

// b4: Send Email to confirms
		sendConfirmRegistrationViaEmail(user.getEmail());
	}

//	b1: khai bao
	private void CreateNewRegistrationToken(User user) {
//		UUID là thuật toán render số khác nhau
//		create new token for confirm Registration
		final String newToken = UUID.randomUUID().toString();
		RegistrationUserToken token = new RegistrationUserToken(newToken, user);
		registrationUserTokenRepository.save(token);
	}

//	b3: bất kỳ ai khai báo email từ OnSendRegistrationViaEmail thì sẽ xử lý 1 event : gửi đến email vừa khai báo 1 email confirm
	private void sendConfirmRegistrationViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendRegistrationViaEmail(email));
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void activeUser(String token) {
//  Update status to Active

		RegistrationUserToken registrationUserToken = registrationUserTokenRepository.findByToken(token);
		User user = registrationUserToken.getUser();
		user.setStatus(UserStatus.ACTIVE);
		userRepository.save(user);
//		Remove token
		registrationUserTokenRepository.deleteById(registrationUserToken.getId());
	}


}

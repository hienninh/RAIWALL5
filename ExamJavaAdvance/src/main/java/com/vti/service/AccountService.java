package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
@Service
public class AccountService implements IAccountService{
@Autowired
private IAccountRepository repository;
	@Override
	public List<Account> getAllAccounts() {
		return repository.findAll();
	}

	@Override
	public Account getAccountByID(short Id) {
		return repository.findById(Id).get();
	}

	@Override
	public void deleteAccountById(short Id) {
		repository.deleteById(Id);
	}

	@Override
	public void updateAccountById(Account account) {
		repository.save(account);
	}

}

package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.AccountDTO;
import com.vti.DTO.viewGroupDTO;
import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.service.IAccountService;
import com.vti.service.IGroupService;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
	@Autowired
	private IAccountService service;
	@Autowired
	private IGroupService groupSerice;

	@GetMapping()
	public ResponseEntity<?> getAllAccounts() {
		AccountDTO dto;
		List<Account> accounts = service.getAllAccounts();
		// convert entiy to DTO
		List<AccountDTO> dtos = new ArrayList<>();
		for (Account account : accounts) {

			List<String> groupName = new ArrayList<>();
			for (Group group : account.getCreatedGroups()) {
				groupName.add(group.getGroupName());
			}
			// convert 1 entity => 1 dto
			dto = new AccountDTO(account.getId(), account.getFullname(), groupName);
			dtos.add(dto);
		}
		return new ResponseEntity<List<AccountDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") short id) {
		Account account = service.getAccountByID(id);
		// convert DTO to Entity
		AccountDTO dto;
		List<String> groupName = new ArrayList<>();
		for (Group group : account.getCreatedGroups()) {
			groupName.add(group.getGroupName());
		}
		dto = new AccountDTO(account.getId(), account.getFullname(), groupName);
		return new ResponseEntity<AccountDTO>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccountById(@PathVariable(name = "id") short id, @RequestBody AccountDTO dto) {
		Account account = dto.toEntity();
		account.setId(id);
		service.updateAccountById(account);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccountById(@PathVariable(name = "id") short id) {
		service.deleteAccountById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}

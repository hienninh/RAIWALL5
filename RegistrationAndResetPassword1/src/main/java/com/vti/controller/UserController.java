package com.vti.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.DTO.UserDTO;
import com.vti.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/Users")
@Validated
public class UserController {
	@Autowired
	private IUserService userSerice;

	@PostMapping()
	public ResponseEntity<?> createGroup(@Valid @RequestBody UserDTO dto) {

		userSerice.createUser(dto.toEntity());

		return new ResponseEntity<String>("We have sent 1 email. Please check email to active account!",
				HttpStatus.CREATED);
	}

	@GetMapping("/activeUser")
	public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) {

		// active user
		userSerice.activeUser(token);

		return new ResponseEntity<>("Active success!", HttpStatus.OK);
	}
}

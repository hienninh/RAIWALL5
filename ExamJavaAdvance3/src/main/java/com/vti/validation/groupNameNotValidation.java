package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.service.IGroupService;

public class groupNameNotValidation implements ConstraintValidator<groupNameNotExist, String> {

	@Autowired
	private IGroupService service;

	// value là groupName người dùng nhập vào
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// nếu không nhập value thì false
		if (value == null) {
			return false;
		}
		// nhập đúng
		return !service.existByGroupName(value);
	}

}

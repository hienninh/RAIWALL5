package com.vti.config.exception.object;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.vti.config.exception.ApiErrorResponse;

public class ApiValidateErrorResponse extends ApiErrorResponse {
	private List<ValidateError> errors;

	public ApiValidateErrorResponse(HttpStatus status, String message, List<ValidateError> errors) {
		super(status, message, "");
		this.errors = errors;
	}

	public List<ValidateError> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidateError> errors) {
		this.errors = errors;
	}

}

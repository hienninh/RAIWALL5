package com.vti.config.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.config.exception.object.ApiValidateErrorResponse;
import com.vti.config.exception.object.ValidateError;
import com.vti.config.intanationalize.MessageProperty;

@Order(Ordered.HIGHEST_PRECEDENCE)
// Khai báo dưới đây có xử lý lỗi global: RestExceptionHandler
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private MessageProperty messageProperty;

//	 Tự dev xử lý handleAll, handleEntityNotFound
	// default exception
//	@ExceptionHandler({ Exception.class })
//	public ResponseEntity<?> handleAll(Exception exception) {
//		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
////				 messageProperty.getMessage(key),
//				"Server đã bị lỗi, liên hệ hien@gmail.com", exception.getMessage());
////	ResponseEntity là obj				
//		return new ResponseEntity<>(error, error.getStatus());
//	}

// not found entity (getByID not found)

	@ExceptionHandler({ EntityNotFoundException.class })
	public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException exception) {
		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.NOT_FOUND, "Lỗi không tìm thấy Entity",
				exception.getMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

	// MissingServletRequestPartException: This exception is thrown when when the
	// part of a multipart request not found
	// MissingServletRequestParameterException: This exception is thrown when
	// request missing parameter:
//	@Override
//	protected ResponseEntity<Object> handleMissingServletRequestParameter(
//			MissingServletRequestParameterException exception, HttpHeaders headers, HttpStatus status,
//			WebRequest request) {
//		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Lỗi không mapping parametor",
//				exception.getMessage());
//		return new ResponseEntity<>(error, error.getStatus());
//	}

//	@Override
//	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException exception,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Lỗi không mapping parametor",
//				exception.getMessage());
//		return new ResponseEntity<Object>(error, error.getStatus());
//	}

	// bean validation error
//	@ExceptionHandler(ConstraintViolationException.class)
//	ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
//		ApiErrorResponse error = new ApiErrorResponse(HttpStatus.BAD_REQUEST, "Lỗi không mapping parametor",
//				exception.getMessage());
//		return new ResponseEntity<>(error, error.getStatus());
//
//	}

//	 handleMethodArgumentNotValidEntity spring đã xử lý => @Override lại
//	@Override
//	@ExceptionHandler
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//		List<ValidateError> errors = new ArrayList<>();
//		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
//			String fieldName = "";
//			for (Object obj : error.getArguments()) {
//				DefaultMessageSourceResolvable argument = (DefaultMessageSourceResolvable) obj;
//				fieldName += argument.getDefaultMessage();
//			}
//			errors.add(new ValidateError(fieldName, error.getDefaultMessage()));
//		}
//		ApiValidateErrorResponse error = new ApiValidateErrorResponse(HttpStatus.BAD_REQUEST, "Lỗi tham số", errors);
//		return new ResponseEntity<>(error, error.getStatus());
//	}
}

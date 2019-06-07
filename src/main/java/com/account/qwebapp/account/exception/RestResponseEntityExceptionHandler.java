package com.account.qwebapp.account.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	@ResponseBody
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String accountNotFoundHandler(AccountNotFoundException ex) {
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(AccountProfileNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String accountProfileNotFoundHandler(AccountProfileNotFoundException ex) {
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(AccountIncorrectInputException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String accountIncorrectInputHandler(AccountIncorrectInputException ex) {
		logger.error(ex.getMessage());
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Please provide valid argument"; // This message string should have been part of properties file for internalization
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

}

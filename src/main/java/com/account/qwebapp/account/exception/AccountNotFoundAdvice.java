package com.account.qwebapp.account.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
public class AccountNotFoundAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountNotFoundAdvice.class); 
	@ResponseBody
	  @ExceptionHandler(AccountNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String accountNotFoundHandler(AccountNotFoundException ex) {
		logger.error(ex.getMessage());
	    return ex.getMessage();
	  }

}

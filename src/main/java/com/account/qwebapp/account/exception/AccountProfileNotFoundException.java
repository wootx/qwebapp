package com.account.qwebapp.account.exception;

import java.util.Locale;

public class AccountProfileNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = -7327788672685988688L;
	
	private Locale locale; // Locale can be populated dynamically. However dynamic nature has not been designed yet in this project
	
	public AccountProfileNotFoundException() {
		super("Incorrect input"); // Rather then message, we could put a key here and key - value pair in properties file for internalization.
	}
	
	public AccountProfileNotFoundException(Long id) {
		super("Incorrect input"); // Rather then message, we could put a key here and key - value pair in properties file for internalization.
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
	}
}

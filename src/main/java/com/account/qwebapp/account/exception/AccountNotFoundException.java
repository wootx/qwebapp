package com.account.qwebapp.account.exception;

public class AccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6798809046469101167L;

	public AccountNotFoundException() {
		super("Could not find accounts ");
	}

	public AccountNotFoundException(Long id) {
		super("Could not find account - " + id + " ");
	}

	public AccountNotFoundException(String userid) {
		super("Could not find account of the user- " + userid + " ");
	}

}

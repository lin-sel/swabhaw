package com.techlabs.exception;

import com.techlabs.account.Account;

public class InsufficientException extends RuntimeException implements IException{

	private static final long serialVersionUID = 1L;
	public String exception;
	
	public InsufficientException(Account account, double amount) {
		this.exception = "Account Holder :"+account.getName()+" have balance "+account.getBalance()+" but they are trying to withdraw "+amount+". 'You have to maintain minimum 2000 balance'.";
	}
	
	@Override
	public String getMessage() {
		return this.exception;
	}
}

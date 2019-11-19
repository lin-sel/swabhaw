package com.techlabs.exception;

public class InsufficientFundException extends Throwable{

	private static final long serialVersionUID = 1L;
	private String exception;
	
	public InsufficientFundException(String exception) {
		this.exception = exception;
	}
	public Boolean isValidFund(double accountbalance, double withdrawbalance,int limit) throws InsufficientFundException {
		if(!(accountbalance-withdrawbalance >= limit)) {
			throw new InsufficientFundException("You can Not Withdraw fund more than "+(accountbalance-limit)+".");
		}
		return true;
	}
	
	public Boolean isValid(double accountbalance, double withdrawbalance) throws InsufficientFundException {
		if((withdrawbalance > accountbalance)) {
			throw new InsufficientFundException("Insufficient Balance");
		}
		return true;
	}
	public String getException() {
		return exception;
	}
	
	
}

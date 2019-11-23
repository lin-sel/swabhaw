package com.techlabs.exception;

public class InvalidAmount extends RuntimeException implements IException{
	private static final long serialVersionUID = 1L;
	String exception;
	
	public InvalidAmount(String message){
		exception = message;
	}
	
	@Override
	public String getMessage() {
		return this.exception;
	}
}

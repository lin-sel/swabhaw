package com.techlabs.account;

public abstract class Account {
	private String accountnumber;
	private String name;
	protected double balance;
	
	public Account(String accountnumber,String name,double balance){
		this.accountnumber = accountnumber;
		this.balance = balance;
		this.name = name;
	}

	public String getAccountnumber() {
		return accountnumber;
	}
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposite(double amount) {
		this.balance = this.balance + amount;
	}
	
	public abstract boolean withdraw(double amount);
}

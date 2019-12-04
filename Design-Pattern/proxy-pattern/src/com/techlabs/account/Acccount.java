package com.techlabs.account;

public class Acccount implements IAccount{
	private String name;
	private String accnumber;
	private double balance;

	public Acccount(String name, String accnumber, double bal) {
		this.name = name;
		this.accnumber = accnumber;
		this.balance = bal;
	}

	public String getName() {
		return name;
	}

	public String getAccnumber() {
		return accnumber;
	}

	@Override
	public void withdraw(int amount) {
		if(this.balance-amount < 500) {
			throw new RuntimeException("insufficient Amount");
		}
		this.balance = this.balance - amount;
	}

	@Override
	public void deposit(int amount) {
		if(amount < 0) {
			throw new RuntimeException("invalid Number");
		}
		this.balance += amount; 
	}

	public double getBalance() {
		return balance;
	}
	
}

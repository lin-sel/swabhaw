package com.techlabs.account;

public class Account {
	private String accountnumber;
	private String name;
	private double balance;
	
	
	public Account(String acc, String name, double bal){
		this.accountnumber = acc;
		this.balance = bal;
		this.name = name;
	}
	
	public Account(String acc, String name) {
		this.accountnumber = acc;
		this.name = name;
		this.balance = 500;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(int bal) {
		this.balance = this.balance+(long)bal;
	}
	
	public boolean withdraw(long amount) {
		if(this.balance > (500+amount)) {
			this.balance -= amount;
		}
		else if(this.balance < (500+amount)){
			return false;
		}
		return true;
	}
}

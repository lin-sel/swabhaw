package com.techlabs.account;

public class Account {
	private String accountnumber;
	private String name;
	private double balance;
	private static int totalaccount = 0;
	
	
	public Account(String acc, String name, double bal){
		this.accountnumber = acc;
		this.balance = bal;
		this.name = name;
		setTotalaccount();
	}
	
	public Account(String acc, String name) {
		this.accountnumber = acc;
		this.name = name;
		this.balance = 500;
		setTotalaccount();
	}
	
	// getter and setter for totalaccount.
	public static int getTotalaccount() {
		return totalaccount;
	}

	private static void setTotalaccount() {
		Account.totalaccount += 1;
	}
	
	// getter and setter for accountnumber.
	public String getAccountnumber() {
		return accountnumber;
	}
	
	// getter and setter for name.
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// getter and setter for balance.
	public double getBalance() {
		return balance;
	}
	
	public void deposit(int bal) {
		this.balance = this.balance+(long)bal;
	}
	
	public boolean withdraw(long amount) {
		if(this.balance >= (500+amount)) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
}

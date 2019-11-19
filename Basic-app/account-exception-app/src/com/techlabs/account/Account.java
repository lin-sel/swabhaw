package com.techlabs.account;

import com.techlabs.exception.InsufficientException;

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
	
	public void withdraw(long amount) {
		if(this.balance >= (500+amount)) {
			this.balance -= amount;
			return ;
		}
		throw new InsufficientException(this,amount);
	}
	
	@Override
	public String toString(){
		String srr = super.toString();
        return "Account Number: "+getAccountnumber()+" Name: "+getName()+" Balance: "+getBalance()+" "+srr;
    }
	
	@Override
	public boolean equals(Object object) {
		Account acc = (Account) object;
		if(this.accountnumber == acc.accountnumber) {
			return true;
		}
		return false;
	}
}

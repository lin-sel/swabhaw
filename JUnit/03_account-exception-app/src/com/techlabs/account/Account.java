package com.techlabs.account;

import org.junit.jupiter.api.Test;

import com.techlabs.exception.InsufficientException;
import com.techlabs.exception.InvalidAmount;

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
	
	@Test
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
	
	@Test
	public void deposit(int bal) {
		if(bal < 0) {
			throw new InvalidAmount("Negative Number Not allowed");
		}
		this.balance = this.balance+(long)bal;
	}
	
	@Test
	public void withdraw(long amount) {
		if(this.balance >= (500+amount)) {
			this.balance -= amount;
			return ;
		}
		throw new InsufficientException(this,amount);
	}
	
	@Test
	@Override
	public String toString(){
        return "Account Number: "+getAccountnumber()+" Name: "+getName()+" Balance: "+getBalance();
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

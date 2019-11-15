package com.techlabs.account;

public class SavingAccount extends Account{
	private int totalaccount = 0;
	public SavingAccount(String accountnumber, String name, double balance) {
		super(accountnumber, name, balance);
		totalaccount += 1;
	}

	@Override
	public boolean withdraw(double amount) {
		if((balance - amount) >= 1000 ) {
			balance = balance - amount;
			return true;
		}
		
		return false;
	}
	
	public int getTotalaccount() {
		return totalaccount;
	}

}

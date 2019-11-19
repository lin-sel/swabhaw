package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.exception.InsufficientFundException;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account("10040409090","Alex",10000);
		boolean status = false;
		try {
			status = account.withdraw(20000);
		}
		catch (InsufficientFundException e) {
			System.out.println(e.getException());
			e.getStackTrace();
		}
		if(status) {
			System.out.println("\nAmount Withdraw Successfully..");
		}
		else {
			System.out.println("\nTransaction Failed....");
		}
	
//		System.out.println(Account.getTotalaccount());
	}
}

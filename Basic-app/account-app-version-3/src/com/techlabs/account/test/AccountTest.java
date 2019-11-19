package com.techlabs.account.test;

import com.techlabs.account.Account;

public class AccountTest {
	public static void main(String[] args) {
		boolean status;
		Account account = new Account("10040409090","Alex",1000);
		try {
			status = account.withdraw(20000);
		}
		catch(RuntimeException e) {
			System.out.println(e);
		}
//		if(status) {
//			System.out.println("Amount Withdraw Successfully..");
//		}
//		else {
//			System.out.println("Transaction Failed....");
//		}
		
		if(account.withdraw(1000)) {
			System.out.println("Amount Withdraw Successfully..");
			System.out.println("Left Account Balance: "+account.getBalance());
		}
		else {
			System.out.println("Transaction Failed....");
		}
		
		System.out.println(Account.getTotalaccount());
	}
}

package com.techlabs.account.test;

import com.techlabs.account.Account;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account("10040409090","Alex",1000);
		account.deposit(1000);
		System.out.println("Account Balance: "+account.getBalance());
		System.out.println("Account Balance: "+account.getAccountnumber());
		if(account.withdraw(20000)) {
			System.out.println("Amount Withdraw Successfully..");
		}
		else {
			System.out.println("Transaction Failed....");
		}
		
		if(account.withdraw(1000)) {
			System.out.println("Amount Withdraw Successfully..");
			System.out.println("Left Account Balance: "+account.getBalance());
		}
		else {
			System.out.println("Transaction Failed....");
		}
	}
}

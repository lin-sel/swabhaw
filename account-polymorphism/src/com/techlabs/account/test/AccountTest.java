package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.account.CurrentAccount;
import com.techlabs.account.SavingAccount;

public class AccountTest {

	public static void main(String[] args) {
		SavingAccount sa = new SavingAccount("10040409090","Nilesh",1500);
		CurrentAccount ca = new CurrentAccount("3000908089","Alex",10000);
		accountInfo(sa);
		accountInfo(ca);
	}
	
	public static void accountInfo(Account acc) {
		System.out.println("Account Details: ");
		acc.deposite(1500);
		System.out.println("Account: "+acc.getAccountnumber());
		System.out.println("Name: "+acc.getName());
		System.out.println("Balance: "+acc.getBalance());
	}

}

package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.exception.InsufficientException;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account("10040409090","Alex",10000);
		try {
			account.withdraw(20000);
		}
		catch(InsufficientException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

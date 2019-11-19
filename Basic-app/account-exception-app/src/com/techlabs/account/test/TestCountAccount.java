package com.techlabs.account.test;

import com.techlabs.account.Account;

public class TestCountAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account1 = new Account("1001","Alex");
		Account account2 = new Account("1003","Jolly");
		Account account3 = new Account("1002","Jack");
		//
		System.out.println(Account.getTotalaccount());
	}

}

package com.techlabs.account.test;

import com.techlabs.account.Account;

public class TestCountAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new Account("1001","Alex");
		 new Account("1003","Jolly");
		 new Account("1002","Jack");
		//
		System.out.println(Account.getTotalaccount());
	}

}

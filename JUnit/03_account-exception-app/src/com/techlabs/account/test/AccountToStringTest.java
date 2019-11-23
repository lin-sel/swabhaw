package com.techlabs.account.test;

import com.techlabs.account.Account;

public class AccountToStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc1 = new Account("10090904040","George",12334.09);
		Account acc2 = new Account("10090904040","Cassy",12000.09);
		Account acc3 = new Account("72180201","Chash",12000.09);
		System.out.println("---");
		System.out.println(acc1.toString());
		System.out.println(acc1.equals(acc2));
		System.out.println(acc1.equals(acc3));
	}

}

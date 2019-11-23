package com.techlabs.account.test;

import com.techlabs.account.Account;

public class AccountEqualityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc1 = new Account("10090904040","George",12334.09);
		Account acc2 = new Account("10090904040","Nilesh",12000.09);
		Account acc3 = new Account("Nilesh","Yadav",12000.09);
		
		System.out.println();
		System.out.println(acc1.equals(acc1));
		System.out.println(acc2.equals(acc3));
		System.out.println(acc1.toString());
	}
	
	

}

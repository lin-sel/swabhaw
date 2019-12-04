package com.techlabs.Test;

import com.techlabs.account.Acccount;
import com.techlabs.account.AccountLogProxy;

public class ProxyTest {

	public static void main(String[] args) {
		AccountLogProxy acc = new AccountLogProxy(new Acccount("Alex","123409", 1000));
		acc.deposit(2000);
		System.out.println(acc.getBalance());
		acc.withdraw(100);
		System.out.println(acc.getBalance());
	}

}

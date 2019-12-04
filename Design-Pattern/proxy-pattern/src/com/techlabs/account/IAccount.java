package com.techlabs.account;

public interface IAccount {
	void withdraw(int amount);
	void deposit(int amount);
	double getBalance();
}

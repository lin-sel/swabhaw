package com.techlabs.account;

import com.techlabs.logger.ILogger;
import com.techlabs.logger.Logger;

public class AccountLogProxy implements IAccount{
	private IAccount account;
	private ILogger logger;

	public AccountLogProxy(IAccount account) {
		this.account = account;
		this.logger = new Logger();
	}

	@Override
	public void withdraw(int amount) {
		this.logger.log();
		this.account.withdraw(amount);
		this.logger.log();
	}

	@Override
	public void deposit(int amount) {
		this.logger.log();
		this.account.deposit(amount);
		this.logger.log();
	}
	
	@Override
	public double getBalance() {
		return account.getBalance();
	}

}

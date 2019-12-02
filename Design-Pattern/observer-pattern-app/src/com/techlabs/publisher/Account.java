package com.techlabs.publisher;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountnumber;
	private String name;
	private double balance;
	private List<INotifier> suscriber;
	
	public Account(String accountnumber, String name, double balance) {
		this.accountnumber = accountnumber;
		this.name = name;
		this.balance = balance;
		suscriber = new ArrayList<>();
	}
	
	public void deposit(double amount) {
		if(amount > -1) {
			this.balance = this.balance + amount;
			callNotifier();
			return;
		}
		throw new RuntimeException("Invalid Amount Enter");
	
	}
	
	private void callNotifier() {
		this.suscriber.forEach((suscribers)->{
			suscribers.sendNotification(this);
		});
	}

	public void withdraw(double amount) {
		if(this.balance > amount) {
			this.balance = this.balance - amount;
			return;
		}
		throw new RuntimeException("Isufficient Balance.");
	}
	
	public void suscribe(INotifier suscriber) {
		if(suscriber != null) {
			this.suscriber.add(suscriber);
			return;
		}
	}
}

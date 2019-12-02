package com.techlabs.suscriber;

import com.techlabs.publisher.Account;
import com.techlabs.publisher.INotifier;

public class SMSNotifier implements INotifier{

	@Override
	public void sendNotification(Account account) {
		System.out.println("Balance State Has Changed.");
	}

}

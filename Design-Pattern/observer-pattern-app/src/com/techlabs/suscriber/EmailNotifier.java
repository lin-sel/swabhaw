package com.techlabs.suscriber;

import com.techlabs.publisher.Account;
import com.techlabs.publisher.INotifier;

public class EmailNotifier implements INotifier{

	@Override
	public void sendNotification(Account account) {
		System.out.println("Email: \n Balance State Has Changed");
	}

}

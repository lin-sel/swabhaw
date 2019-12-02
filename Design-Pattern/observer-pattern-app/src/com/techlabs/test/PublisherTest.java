package com.techlabs.test;

import com.techlabs.publisher.Account;
import com.techlabs.suscriber.EmailNotifier;
import com.techlabs.suscriber.SMSNotifier;

public class PublisherTest {

	public static void main(String[] args) {
		Account account = new Account("1234567890","ABCED",2000);
		account.suscribe(new SMSNotifier());
		account.suscribe(new EmailNotifier());
		account.deposit(2000);
	}

}

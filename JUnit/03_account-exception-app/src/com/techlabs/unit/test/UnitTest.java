package com.techlabs.unit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.techlabs.account.Account;
import com.techlabs.exception.InsufficientException;
import com.techlabs.exception.InvalidAmount;

class UnitTest {
	Account account = new Account("10040409090","Alex",20000);
	@Test
	void account_Details_Test() {
		String excepted = "Account Number: 10040409090 Name: Alex Balance: 20000.0";
		assertEquals(excepted,account.toString());
	}
	
	@Test
	void account_deposite_test() {
		account.deposit(1000);
		assertTrue(21000 == account.getBalance());
	}
	
	@Test
	void negativeNumber_NotAllowedIn_Deposite() {
		assertThrows(InvalidAmount.class, ()->{
			account.deposit(-1000);
		});
	}
	
	@Test
	void amountWithdraw() {
		account.withdraw(10000);
		assertTrue(10000 == account.getBalance());
	}
	
	@Test
	void ammoutWithdraw_throw_InsufficientException() {
		assertThrows(InsufficientException.class, ()->{
			account.withdraw(30000);
		});
	}

}

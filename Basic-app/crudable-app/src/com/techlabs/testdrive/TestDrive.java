package com.techlabs.testdrive;

import com.techlabs.address.AddressDB;
import com.techlabs.customer.CustomerDB;
import com.techlabs.icrudable.Icrudable;
import com.techlabs.invoice.InvoiceDB;

public class TestDrive {

	public static void main(String[] args) {
		doCrudOption(new AddressDB());
		doCrudOption(new InvoiceDB());
		doCrudOption(new CustomerDB());
	}
	
	public static void doCrudOption(Icrudable icrude) {
		System.out.println(icrude.create("String"));
		System.out.println(icrude.delete("String"));
		System.out.println(icrude.read());
		System.out.println(icrude.update("String"));
	}

}

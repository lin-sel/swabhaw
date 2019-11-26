package com.techlabs.srp.violence.test;

import com.techlabs.srp.violence.Invoice;

public class ViolenceTest {

	public static void main(String[] args) {
		Invoice invoice = new Invoice(101,"ABC",20,28.25,10000);
		invoice.printInvoiceDetail();
	}

}

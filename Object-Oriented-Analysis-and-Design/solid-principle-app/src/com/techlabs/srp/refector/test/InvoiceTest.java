package com.techlabs.srp.refector.test;

import com.techlabs.srp.refactor.InvoicePrinter;
import com.techlabs.srp.refactor.Invoice;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice invoice = new Invoice(101,"ABC",20,28.25,10000);
		InvoicePrinter invoiceprinter = new InvoicePrinter(invoice);
		System.out.println(invoiceprinter.getInvoiceDetail());
	}

}

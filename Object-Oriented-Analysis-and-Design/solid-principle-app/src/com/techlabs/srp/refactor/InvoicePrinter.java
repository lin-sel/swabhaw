package com.techlabs.srp.refactor;

public class InvoicePrinter {
	private Invoice invoice;
	
	
	public InvoicePrinter(Invoice invoice2) {
		this.invoice = invoice2;
	}
	
	public String getInvoiceDetail() {
		return "Id : "+ invoice.getId() + 
				"\nName: "+invoice.getName() + 
				"\nDiscount: "+invoice.discount() + 
				"\nGST: "+invoice.getGst() +
				"\nCost: "+invoice.getCost()+
				"\nTax :"+invoice.calculateTax()+
				"\nTotal Cost:"+invoice.calculateTotalCost();
	}
}

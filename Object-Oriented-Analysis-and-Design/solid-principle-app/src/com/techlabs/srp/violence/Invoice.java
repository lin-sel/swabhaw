package com.techlabs.srp.violence;

public class Invoice {
	private int id;
	private String name;
	private double discount;
	private double gst;
	private double cost;
	
	public Invoice(int id, String name, double discount, double gst, double cost) {
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.gst = gst;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getDiscount() {
		return discount;
	}

	public double getGst() {
		return gst;
	}
	
	public double discount() {
		return (cost * discount)/100;
	}
	
	public double calculateTax() {
		return (gst * cost ) /100;
	}
	
	public double calculateTotalCost() {
		return (calculateTax() + cost ) - discount();
	}
	
	public void printInvoiceDetail() {
		System.out.println("Id : "+this.id);
		System.out.println("Name: "+this.name);
		System.out.println("Discount: "+this.discount());
		System.out.println("GST: "+this.gst);
		System.out.println("Cost: "+this.cost);
		System.out.println("Tax :"+this.calculateTax());
		System.out.println("Total Cost:"+this.calculateTotalCost());
	}
}

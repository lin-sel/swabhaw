package com.techlabs.srp.refactor;

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

	public double getCost() {
		return cost;
	}
	
	
}

package com.techlabs.product;

public class Product {
	private int id;
	private String name;
	private double cost;
	private double discount;
	
	public Product(int id, String name, double cost, double discount) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public boolean equals(Object obj) {
		Product product = (Product) obj;
		if(product.id == this.id) {
			return true;
		}
		return false;
	}
	
	
	
	
	
}

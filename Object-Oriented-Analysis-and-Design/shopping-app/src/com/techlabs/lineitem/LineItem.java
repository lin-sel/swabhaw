package com.techlabs.lineitem;

import com.techlabs.product.Product;

public class LineItem {
	private int id;
	private Product product;
	private int quantity;
	
	public LineItem(int id, Product product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public double calculateItemCost() {
		return product.getCost() * quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = this.quantity + quantity;
	}

	@Override
	public boolean equals(Object obj) {
		LineItem item = (LineItem) obj;
		if(item.product.equals(item.product)) {
			return true;
		}
		return false;
	}
}

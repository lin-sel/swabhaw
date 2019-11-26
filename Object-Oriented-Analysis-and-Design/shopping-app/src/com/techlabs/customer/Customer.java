package com.techlabs.customer;

import java.util.ArrayList;
import java.util.List;
import com.techlabs.order.Order;

public class Customer {
	private int id;
	private String name;
	private List<Order> order = new ArrayList<>();
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addItem(Order item) {
		order.add(item);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Order> getOrder() {
		return order;
	}
}

package com.techlabs.order;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.lineitem.LineItem;

public class Order {
	private int id;
	private String date;
	private List<LineItem> itemlist = new ArrayList<LineItem>();
	
	public Order(int id, String date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	public void addItem(LineItem lineitem) {
		if(!comapare(lineitem)) {
			itemlist.add(lineitem);
		}
	}

	

	private boolean comapare(LineItem lineitem) {
		for(LineItem lineitems : itemlist) {
			if(lineitems.equals(lineitem)) {
				lineitems.setQuantity(lineitem.getQuantity());
				return true;
			}
		}
		return false;
	}

	public double checkout() {
		double price = 0;
		for(LineItem item : itemlist) {
			price = price + item.calculateItemCost();
		}
		return price;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public List<LineItem> getItemlist() {
		return itemlist;
	}
	
}

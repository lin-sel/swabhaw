package com.techlabs.line.item;

public class LineItem  implements Comparable<LineItem> {
	private int itemid;
	private String productname;
	private int quantity;
	private double cost;
	
	public LineItem(int id, String productname, int quantity, double cost){
		this.itemid = id;
		this.productname = productname;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public LineItem(int id, String productname, double cost){
		this(id,productname,1,cost);
	}

	public int getId() {
		return itemid;
	}

	public String getProductname() {
		return productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getCost() {
		return cost;
	}
	
	public double calculateItemCost() {
		return this.cost * this.quantity;
	}
	
	@Override
	public int hashCode() {
		return this.itemid;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return true;
		return false;
		
	}

	@Override
	public int compareTo(LineItem o) {
		Integer thisid = (Integer)this.getId();
		return thisid.compareTo((Integer)o.getId());
	}
}

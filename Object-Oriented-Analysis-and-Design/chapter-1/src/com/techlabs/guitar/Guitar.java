package com.techlabs.guitar;

import java.io.Serializable;

public class Guitar implements Serializable{
	private static final long serialVersionUID = -2623003420134921882L;
	private String serialNumber;
	private String builder;
	private double price;
	public Guitar(String serialNumber, String builder, double price, String model, String type, String backwood,String topwood) {
		this.serialNumber = serialNumber;
		this.builder = builder;
		this.price = price;
		this.model = model;
		this.type = type;
		this.backwood = backwood;
		this.topwood = topwood;
	}
	private String model;
	private String type;
	private String backwood;
	private String topwood;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public String getBuilder() {
		return builder;
	}
	public String getModel() {
		return model;
	}
	public String getType() {
		return type;
	}
	public String getBackwood() {
		return backwood;
	}
	public String getTopwood() {
		return topwood;
	}
}

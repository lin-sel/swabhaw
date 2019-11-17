package com.techlabs.guitar;

import java.io.Serializable;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;

public class Guitar implements Serializable{
	private static final long serialVersionUID = -2623003420134921882L;
	private String serialNumber;
	private Builder builder;
	private double price;
	private String model;
	private Type type;
	private Wood backwood;
	private Wood topwood;
	
	public Guitar(String serialNumber, Builder builder, double price, String model, Type type, Wood backwood,Wood topwood) {
		this.serialNumber = serialNumber;
		this.builder = builder;
		this.price = price;
		this.model = model;
		this.type = type;
		this.backwood = backwood;
		this.topwood = topwood;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public Builder getBuilder() {
		return builder;
	}
	public String getModel() {
		return model;
	}
	public Type getType() {
		return type;
	}
	public Wood getBackwood() {
		return backwood;
	}
	public Wood getTopwood() {
		return topwood;
	}
}

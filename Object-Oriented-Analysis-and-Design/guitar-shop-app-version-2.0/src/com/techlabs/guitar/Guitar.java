package com.techlabs.guitar;

import java.io.Serializable;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;

public class Guitar extends GuitarSpecification implements Serializable {
	private static final long serialVersionUID = -2623003420134921882L;
	private String serialNumber;
	private double price;
	
	public Guitar(String serialNumber, Builder builder, double price, String model, Type type, Wood backwood,Wood topwood) {
		super(builder,model,type,backwood,topwood);
		this.serialNumber = serialNumber;
		this.price = price;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}

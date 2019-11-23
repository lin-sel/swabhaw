package com.techlabs.bus;

import java.io.Serializable;

public class Bus implements Cloneable,Serializable{
	private static final long serialVersionUID = 1L;
	private String model;
	private String color = "color";
	private String dimension;
	
	public Bus(String model, String color, String dimension) {
		super();
		this.model = model;
		this.color = color;
		this.dimension = dimension;
	}
	
	public Bus() {
		
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

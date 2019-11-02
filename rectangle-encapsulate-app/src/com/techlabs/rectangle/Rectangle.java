package com.techlabs.rectangle;

public class Rectangle {
	
	private int width;
	private int height;
	private String color;
	
	// Calculating Area of Rectangle
	public int areaCalculate() {
		return this.width * this.height;
	}
	
	// Getting Background Color
	public String backgroundColor() {
		return this.color;
	}
	// Setting width 
	public void setWidth(int width) {
		this.width = validate(width);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getheight() {
		return this.height;
	}
	
	public String getColor() {
		return this.color;
	}
	
	// Setting height 
	public void setHeight(int height) {
		this.height = validate(height);
	}
	
	// Business Logic for Setting height and width
	private int validate(int data) {
		// max value for both width, height
		final int max = 100;
		
		// min value for both width, height
		final int min = 1;
		
		if(data > max) {
			data = max;
		}
		if(data < min) {
			data = min;
		}
		return data;
	}
	
	// Business Logic for Color
		private String validate(String data) {
			// max value for both width, height
			if("red".compareToIgnoreCase(data) == 0 || "green".compareToIgnoreCase(data) == 0 || "blue".compareToIgnoreCase(data) == 0) {
				return data;
			}
			return "red";
		}
	
	public void setColor (String color) {
		this.color = validate(color);
	}
	

}

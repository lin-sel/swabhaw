package com.techlabs.dog;

public class Dog {
	private int size;
	private String name;
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String bark() {
		if(size > 60)
			return "Woof! Woof!";
		else if(size > 14)
			return "Ruff! Ruff!";
		return "Yip! Yip!";
	}
}

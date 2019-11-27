package com.techlabs.lsp.violence;

public class Square extends Rectangle{

	public Square(int size) {
		super(size, size);
	}
	
	@Override
	public void setWidth(int width) {
		this.height = width;
		this.width = width;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}
	
	

}

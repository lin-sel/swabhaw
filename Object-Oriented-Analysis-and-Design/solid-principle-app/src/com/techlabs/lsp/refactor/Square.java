package com.techlabs.lsp.refactor;

public class Square implements Polygon{
	private int size;
	
	public Square(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int calculateArea() {
		return this.size * this.size;
	}
}

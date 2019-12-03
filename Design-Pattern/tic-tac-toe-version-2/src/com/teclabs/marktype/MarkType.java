package com.teclabs.marktype;

public enum MarkType {
	CROSS,
	CIRCLE,
	DEFAULT;
	
	@Override
	public String toString() {
		switch(this) {
		case CROSS:
			return "X";
		case CIRCLE:
			return "O";
		case DEFAULT:
		}
		return " ";
	}
}

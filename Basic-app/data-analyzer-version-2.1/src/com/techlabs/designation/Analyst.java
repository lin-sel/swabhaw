package com.techlabs.designation;

public class Analyst implements Designation{
	private String designation = "Analyst";

	@Override
	public String getDesignation() {
		return this.designation;
	}

	@Override
	public Designation equalsClass(Object object) {
		if(this.getClass().toString().equalsIgnoreCase((String)object)) {
			return new President();
		}
		return null;
	}
}

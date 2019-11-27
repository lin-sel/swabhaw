package com.techlabs.designation;

public class Clerk implements Designation{
	private String designation = "Clerk"; 
	
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

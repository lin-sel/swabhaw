package com.techlabs.dog;

public class Bark {
	private String barks;
	
	public Bark(String barks) {
		this.barks = barks;
	}
	
	public String getBarks() {
		return barks;
	}

	public void setBarks(String barks) {
		this.barks = barks;
	}	
	
	public boolean equal(Object barks) {
		if(barks instanceof Bark) {
			Bark obj = (Bark) barks;
			if(this.getBarks().equalsIgnoreCase(obj.getBarks())) {
				return true;
			}
		}
		return false;
		
	}
}

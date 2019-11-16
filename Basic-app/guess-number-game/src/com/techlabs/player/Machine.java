package com.techlabs.player;

public class Machine {
	
	private int inputnumber;
	
	public int getInputnumber() {
		setInputnumber((int)(Math.random()*10));
		return this.inputnumber;
	}

	private void setInputnumber(int num) {
		this.inputnumber = num;
	}
	
}

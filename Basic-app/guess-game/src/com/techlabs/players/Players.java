package com.techlabs.players;

public class Players {
	private int randnumber;
	
	private void generateRandonNumber() {
		this.randnumber = (int)(Math.random()*10);
	}
	
	public int getrandNum() {
		generateRandonNumber();
		return this.randnumber;
	}
}

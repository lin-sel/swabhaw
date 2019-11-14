package com.techlabs.guessgame.player;

public class TargetNumber {
	private int targetnumber;
	
	public void setTargetNumber() {
		this.targetnumber = (int)(Math.random()*10);
	}
	
	public int getTargetNumber() {
		setTargetNumber();
		return this.targetnumber;
	}
}

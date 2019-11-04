package com.techlabs.randnumgenerator;

public class RanNumGenerate {
	private int autoguessnumber;
	
	private void guessNumberBySystem() {
		this.autoguessnumber = (int)Math.random()*10;
	}
	
	public int getSysGenRanNumber() {
		guessNumberBySystem();
		return this.autoguessnumber;
	}
}

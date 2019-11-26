package com.techlabs.ocp.festivaltype;

public class Normal implements IFestival{
	private final double rate = 0.07;
	
	@Override
	public double getRate() {
		return this.rate;
	}
}

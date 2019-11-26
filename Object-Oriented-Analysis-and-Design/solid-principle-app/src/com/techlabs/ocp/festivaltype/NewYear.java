package com.techlabs.ocp.festivaltype;

public class NewYear implements IFestival{
	private final double rate = 0.09;
	@Override
	public double getRate() {
		return this.rate;
	}
}

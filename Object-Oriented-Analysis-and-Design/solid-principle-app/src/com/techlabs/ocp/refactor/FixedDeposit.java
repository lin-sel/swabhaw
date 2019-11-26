package com.techlabs.ocp.refactor;

import com.techlabs.ocp.festivaltype.IFestival;

public class FixedDeposit {
	private String name;
	private double premieramount;
	private int duration;
	private IFestival festival;
	
	public FixedDeposit(String name, double premieramount, int duration, IFestival festival) {
		this.name = name;
		this.premieramount = premieramount;
		this.duration = duration;
		this.festival = festival;
	}

	public String getName() {
		return name;
	}

	public double getPremieramount() {
		return premieramount;
	}

	public int getDuration() {
		return duration;
	}

	public IFestival getFestival() {
		return festival;
	}
	
	public double simpleInterest() {
		return (premieramount * this.festival.getRate()) / 100;
		
	}
	
	
}

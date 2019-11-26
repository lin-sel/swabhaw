package com.techlabs.ocp.violence;

public class FixedDeposit {
	private String name;
	private double premieramount;
	private int duration;
	private FestivalType festival;
	
	public FixedDeposit(String name, double premieramount, int duration, FestivalType festival) {
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

	public FestivalType getFestival() {
		return festival;
	}
	
	public double simpleInterest() {
		return (premieramount * getInterestPercentage(festival)) / 100;
		
	}
	
	private double getInterestPercentage(FestivalType type) {
		if(type == FestivalType.HOLI) {
			return 0.08;
		}
		else if(type == FestivalType.NEW_YEAR) {
			return 0.09;
		}
		return 0.07;
	}
}

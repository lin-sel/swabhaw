package com.techlabs.instrument;

public class Instrument {
	private String serialnumber;
	private double price;
	private InstrumentSpec instrumentspec;
	
	public Instrument(String serialnuber, double price, InstrumentSpec instrumentspec) {
		this.serialnumber = serialnuber;
		this.price = price;
		this.instrumentspec = instrumentspec;
	}

	public String getSerialNumber() {
		return serialnumber;
	}

	public double getPrice() {
		return price;
	}

	public InstrumentSpec getInstrumentspec() {
		return instrumentspec;
	}

}

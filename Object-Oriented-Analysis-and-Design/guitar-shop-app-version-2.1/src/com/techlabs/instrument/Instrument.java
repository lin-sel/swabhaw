package com.techlabs.instrument;

public abstract class Instrument {
	protected String serialnuber;
	protected double price;
	protected InstrumentSpec instrumentspec;
	
	public Instrument(String serialnuber, double price, InstrumentSpec instrumentspec) {
		this.serialnuber = serialnuber;
		this.price = price;
		this.instrumentspec = instrumentspec;
	}

	public String getSerialnuber() {
		return serialnuber;
	}


	public double getPrice() {
		return price;
	}

	public InstrumentSpec getInstrumentspec() {
		return instrumentspec;
	}

}

package com.techlabs.guitar;

import com.techlabs.instrument.Instrument;

public class Guitar extends Instrument {

	private GuitarSpec giutarspec;

	public Guitar(String serialnuber, double price, GuitarSpec instrumentspec) {
		super(serialnuber, price, instrumentspec);
		this.giutarspec = instrumentspec;
	}

	public GuitarSpec getGiutarspec() {
		return giutarspec;
	}
}

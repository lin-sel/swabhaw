package com.techlabs.guitar;

import com.techlabs.instrument.Instrument;
import com.techlabs.instrument.InstrumentSpec;

public class Guitar extends Instrument {

	private GuitarSpec giutarspec;
	
	public Guitar(String serialnuber, double price, InstrumentSpec instrumentspec, GuitarSpec giutarspec) {
		super(serialnuber, price, instrumentspec);
		this.giutarspec = giutarspec;
	}

	public GuitarSpec getGiutarspec() {
		return giutarspec;
	}
}

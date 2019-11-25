package com.techlabs.mandolin;

import com.techlabs.instrument.Instrument;
import com.techlabs.instrument.InstrumentSpec;

public class Mandolin extends Instrument {
	private MandolinSpec mandolinspec;

	public Mandolin(String serialnuber, double price, InstrumentSpec instrumentspec, MandolinSpec mandolinspec) {
		super(serialnuber, price, instrumentspec);
		this.mandolinspec = mandolinspec;
	}

	public MandolinSpec getMandolinspec() {
		return mandolinspec;
	}
	
	
}

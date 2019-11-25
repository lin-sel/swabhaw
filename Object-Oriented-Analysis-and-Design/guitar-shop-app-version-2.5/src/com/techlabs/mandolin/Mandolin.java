package com.techlabs.mandolin;

import com.techlabs.instrument.Instrument;

public class Mandolin extends Instrument {
	private MandolinSpec mandolinspec;

	public Mandolin(String serialnuber, double price, MandolinSpec mandolinspec) {
		super(serialnuber, price, mandolinspec);
		this.mandolinspec = mandolinspec;
	}

	public MandolinSpec getMandolinspec() {
		return mandolinspec;
	}

}

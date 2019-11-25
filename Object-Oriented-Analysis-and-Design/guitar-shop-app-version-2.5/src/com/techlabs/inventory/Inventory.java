package com.techlabs.inventory;

import java.util.ArrayList;
import java.util.Iterator;
import com.techlabs.guitar.Guitar;
import com.techlabs.guitar.GuitarSpec;
import com.techlabs.instrument.Instrument;
import com.techlabs.instrument.InstrumentSpec;
import com.techlabs.mandolin.Mandolin;
import com.techlabs.mandolin.MandolinSpec;

public class Inventory {
	private ArrayList<Instrument> instrumentlist = new ArrayList<>();

	// Add Guitar To the list
	public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentspec) {
		if (instrumentspec instanceof GuitarSpec) {
			instrumentlist.add(new Guitar(serialNumber, price, (GuitarSpec) instrumentspec));
		} else if (instrumentspec instanceof MandolinSpec) {
			instrumentlist.add(new Mandolin(serialNumber, price, (MandolinSpec) instrumentspec));
		}
	}

	// Find Instrument..
	public Instrument getInstrument(String serialnumber) {
		for (Iterator<Instrument> i = instrumentlist.iterator(); i.hasNext();) {
			Instrument instrument = i.next();
			if (instrument.getSerialNumber().equals(serialnumber))
				return instrument;
		}
		return null;
	}

	// Search Guitar Based On Ideal Guitar's Parameter.
	public ArrayList searchInstrument(InstrumentSpec instrumentspec) {
		ArrayList searchlist = new ArrayList<>();
		for (Iterator<Instrument> i = instrumentlist.iterator(); i.hasNext();) {
			Instrument instrument = (Instrument) i.next();
			if (instrument.getInstrumentspec().matches(instrumentspec)) {
				searchlist.add(instrument);
			}
		}
		return searchlist;
	}

}

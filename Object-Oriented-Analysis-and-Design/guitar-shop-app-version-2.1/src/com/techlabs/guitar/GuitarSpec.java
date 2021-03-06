package com.techlabs.guitar;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;
import com.techlabs.instrument.InstrumentSpec;

public class GuitarSpec extends InstrumentSpec {
	private int numstring;

	public GuitarSpec(Builder builder, String model, Type type, Wood backwood, Wood topwood, int numstring) {
		super(builder, model, type, backwood, topwood);
		this.numstring = numstring;
	}

	public int getNumstring() {
		return numstring;
	} 
	
}

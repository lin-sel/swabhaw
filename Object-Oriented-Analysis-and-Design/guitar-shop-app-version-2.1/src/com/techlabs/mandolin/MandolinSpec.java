package com.techlabs.mandolin;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Style;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;
import com.techlabs.instrument.InstrumentSpec;

public class MandolinSpec  extends InstrumentSpec{
	private Style style;

	public MandolinSpec(Builder builder, String model, Type type, Wood backwood, Wood topwood, Style style) {
		super(builder, model, type, backwood, topwood);
		this.style = style;
	}

	public Style getStyle() {
		return style;
	}
	
	
	
}

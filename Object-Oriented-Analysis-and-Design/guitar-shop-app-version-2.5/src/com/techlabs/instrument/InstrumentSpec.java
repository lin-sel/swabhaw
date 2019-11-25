package com.techlabs.instrument;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;

public class InstrumentSpec {
	protected Builder builder;
	protected String model;
	protected Type type;
	protected Wood backwood;
	protected Wood topwood;
	
	// Constructor
	public InstrumentSpec(Builder builder, String model, Type type, Wood backwood, Wood topwood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backwood = backwood;
		this.topwood = topwood;
	}
	
	// Getter
	public Builder getBuilder() {
		return builder;
	}
	public String getModel() {
		return model;
	}
	public Type getType() {
		return type;
	}
	public Wood getBackwood() {
		return backwood;
	}
	public Wood getTopwood() {
		return topwood;
	}
	
	public boolean matches(InstrumentSpec instrumentspec) {
		
		if(instrumentspec.backwood != backwood) {
			return false;
		}
		if(instrumentspec.builder != this.builder) {
			return false;
		}
		if(instrumentspec.model != this.model) {
			return false;
		}
		if(instrumentspec.topwood != this.topwood) {
			return false;
		}
		if(instrumentspec.type != this.type) {
			return false;
		}
		
		return true;
	}
}

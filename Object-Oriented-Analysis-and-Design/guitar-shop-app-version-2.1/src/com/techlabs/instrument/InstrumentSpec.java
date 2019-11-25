package com.techlabs.instrument;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;

public abstract class InstrumentSpec {
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
	
}

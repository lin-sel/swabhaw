package com.techlabs.guitar;

import java.io.Serializable;

import com.techlabs.constant.Builder;
import com.techlabs.constant.Type;
import com.techlabs.constant.Wood;

public abstract class GuitarSpecification implements Serializable{
	private static final long serialVersionUID = 5036144058390142034L;
	protected Builder builder;
	protected String model;
	protected Type type;
	protected Wood backwood;
	protected Wood topwood;
	
	// Constructor
	public GuitarSpecification(Builder builder, String model, Type type, Wood backwood, Wood topwood) {
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

package com.techlabs.instrument;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
	private Map property ;
	
	// Constructor
	public InstrumentSpec(Map property) {
		if(property != null) {
			this.property = new HashMap(property);
			return;
		}
		this.property = new HashMap();
	}
	
	// Getter
	public Object getProperty(String propertyName) {
		if(propertyName != null) {
			return this.property.get(propertyName);
		}
		return null;
	}
	
	public Map getProperties() {
		return this.property;
	}
	
	public boolean matches(InstrumentSpec instrumentspec) {
		for(Iterator i = instrumentspec.getProperties().keySet().iterator(); i.hasNext();) {
			String propertyName = (String) i.next();
			if(!this.property.get(propertyName).equals(instrumentspec.getProperty(propertyName))) {
				return false;
			}
		}
		return true;
	}
}

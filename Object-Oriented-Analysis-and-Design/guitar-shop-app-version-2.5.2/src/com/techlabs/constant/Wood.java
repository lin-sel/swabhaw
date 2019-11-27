package com.techlabs.constant;

import java.io.Serializable;

public enum Wood implements Serializable{
	INDIAN_ROSEWOOD,
	BRAZILIAN_ROSEWOOD,
	MAHOGNY,
	MAPLE,
	COCOBOLO,
	CEDAR,
	ADIRONDACK,
	ALDER,
	SITKA;
	
	public String toString() {
		switch(this){
		case INDIAN_ROSEWOOD:
			return "Indian Rosewood";
		case BRAZILIAN_ROSEWOOD:
			return "Brazilian Rosewood";
		case MAHOGNY:
			return "Mahogny";
		case MAPLE:
			return "Maple";
		case COCOBOLO:
			return "Cocobolo";
		case CEDAR:
			return "Cedar";
		case ADIRONDACK:
			return "Adirondack";
		case ALDER:
			return "Alder";
		case SITKA:
			return "Sitka";
		}
		return null;
	}
}

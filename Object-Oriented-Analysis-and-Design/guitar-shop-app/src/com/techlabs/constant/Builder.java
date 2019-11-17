package com.techlabs.constant;

import java.io.Serializable;

public enum Builder implements Serializable{
	FENDER, MARTIN, GIBSON, COLING, OLSON, RYAN, PRS, ANY;
	
	public String toString() {
		switch(this) {
		case FENDER:
			return "Fender";
		case MARTIN:
			return "Martin";
		case GIBSON:
			return "Gibson";
		case COLING:
			return "Coling";
		case OLSON:
			return "Olsen";
		case RYAN:
			return "Ryan";
		case PRS:
			return "PRS";
		case ANY:
			return "Any";
		}
		return null;
	}
}

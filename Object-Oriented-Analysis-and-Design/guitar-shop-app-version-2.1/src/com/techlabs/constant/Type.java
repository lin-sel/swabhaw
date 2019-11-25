package com.techlabs.constant;

import java.io.Serializable;

public enum Type implements Serializable{
	ACOUSTIC,ELECTRIC;
	
	public String toString() {
		switch(this) {
		case ACOUSTIC:
			return "Acoustic";
			
		case ELECTRIC:
			return "Electric";
		}
	return null;
	}
}

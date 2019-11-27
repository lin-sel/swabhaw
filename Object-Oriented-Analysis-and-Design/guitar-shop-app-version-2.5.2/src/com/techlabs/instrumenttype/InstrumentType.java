package com.techlabs.instrumenttype;

public enum InstrumentType {
	GUITAR, MANDOLIN, DOBRO;
	
	@Override
	public String toString() {
		switch(this) {
		case GUITAR:
			return "Guitar";
		case MANDOLIN:
			return "Mandolin";
		case DOBRO:
			return "Dobro";
		}
		return null;
	}
}

package com.techlabs.student.branch;

public enum Branch {
	CSE,IT,CIVIL,EXTC,EXT,MECH;
	
	@Override 
	public String toString() {
		switch(this) {
		case CSE:
			return "Computer Science and Engineering";
			
		case IT:
			return "Information Technology";
			
		case EXTC:
			return "Elextronic and Telecommunication Engineering";
			
		case EXT:
			return "Electronic Engineering";
			
		case MECH:
			return "Mechanical Engineering";
		default:
			break;
		}
		return null;
	}
}

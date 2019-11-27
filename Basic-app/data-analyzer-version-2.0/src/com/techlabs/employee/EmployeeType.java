package com.techlabs.employee;

public enum EmployeeType {
	ANALYST,MANAGER,PRESIDENT,SALESMAN, CLERK;
	
//	@Override
	public String toString() {
		switch(this) {
		case ANALYST: return "Analyst";
		case MANAGER: return "Manager";
		case PRESIDENT: return "President";
		case SALESMAN: return "Salesman";
		case CLERK: return "Clerk";
		}
		return "Undefined";
	}
}

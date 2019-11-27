package com.techlabs.constant;

public enum Designation {
	ANALYST,MANAGER,PRESIDENT,CLERK,SALESMAN;

	@Override
	public String toString() {
		switch(this) {
		case ANALYST:
			return "Analyst";
		case MANAGER:
			return "Manager";
		case PRESIDENT:
			return "President";
		case CLERK:
			return "Clerk";
		case SALESMAN:
			return "Salesman";
		default:
			return "0";
		}
	}
}

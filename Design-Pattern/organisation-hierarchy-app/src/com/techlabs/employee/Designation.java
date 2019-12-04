package com.techlabs.employee;

public enum Designation {
	PRESIDENT, MANAGER, CLERK, ANALYST, SALESMAN;

	@Override
	public String toString() {
		switch (this) {
		case PRESIDENT:
			return "President";
		case MANAGER:
			return "Manager";
		case CLERK:
			return "Clerk";
		case ANALYST:
			return "Analyst";
		case SALESMAN:
			return "SalesMan";
		}
		return null;
	}
}

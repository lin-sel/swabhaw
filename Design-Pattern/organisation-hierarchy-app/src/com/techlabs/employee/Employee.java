package com.techlabs.employee;

public class Employee {
	private int commission;
	private int managerid;
	private EmployeeSpec spec;
	
	public Employee(int commission, int managerid, EmployeeSpec spec) {
		this.commission = commission;
		this.managerid = managerid;
		this.spec = spec;
	}

	public int getCommission() {
		return commission;
	}

	public int getManagerid() {
		return managerid;
	}

	public EmployeeSpec getSpec() {
		return spec;
	}
	
	
	
	
}

package com.techlabs.employee;

public class Employee implements Comparable<Employee>{

	private EmployeeSpec employeespec;
	private String departmentid;
	private String managerid;
	private String commission;

	public Employee(EmployeeSpec employeespec, String departmentid, String managerid, String commission) {
		super();
		this.employeespec = employeespec;
		this.departmentid = departmentid;
		this.managerid = managerid;
		this.commission = commission;
	}

	public EmployeeSpec getEmployeespec() {
		return employeespec;
	}

	public int getDepartmentid() {
		if(departmentid == "NULL") {
			return Integer.MIN_VALUE;
		}
		return Integer.parseInt(this.departmentid);
	}

	public String getManagerid() {
		return managerid;
	}

	public String getCommission() {
		return commission;
	}

	@Override
	public int compareTo(Employee o) {
		return this.employeespec.compareTo(o.employeespec);
	}

}

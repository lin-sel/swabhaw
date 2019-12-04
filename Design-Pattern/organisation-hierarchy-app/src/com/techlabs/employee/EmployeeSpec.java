package com.techlabs.employee;

public class EmployeeSpec {
	private int id;
	private String name;
	private Designation designation;
	private String joiningdata;
	private int salary;
	private int department;
	
	public EmployeeSpec(int id, String name, Designation designation, String joiningdata, int salary, int department) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.joiningdata = joiningdata;
		this.salary = salary;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Designation getDesignation() {
		return designation;
	}

	public String getJoiningdata() {
		return joiningdata;
	}

	public int getSalary() {
		return salary;
	}

	public int getDepartment() {
		return department;
	}
	
	
	
}

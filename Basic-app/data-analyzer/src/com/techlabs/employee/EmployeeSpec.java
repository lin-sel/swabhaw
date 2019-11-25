package com.techlabs.employee;

import com.techlabs.constant.Designation;

public class EmployeeSpec {
	private int id;
	private String name;
	private Designation designation;
	private String dateofjoining;
	private int salary;
	
	public EmployeeSpec(int id, String name, Designation designation, String dateofjoining, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.dateofjoining = dateofjoining;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Designation getDesignation() {
		return this.designation;
	}



	public void setDesignation(Designation designation) {
		this.designation = designation;
	}



	public String getDateofjoining() {
		return dateofjoining;
	}



	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}



	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}
}

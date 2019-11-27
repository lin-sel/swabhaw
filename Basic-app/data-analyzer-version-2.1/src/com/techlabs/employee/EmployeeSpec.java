package com.techlabs.employee;

import com.techlabs.designation.DDesignation;
import com.techlabs.designation.Designation;

public class EmployeeSpec implements Comparable<EmployeeSpec>{
	private int id;
	private String name;
	private Designation designation;
	private String dateofjoining;
	private int salary;
	
	public EmployeeSpec(int id, String name, Designation designation, String dateofjoining, int salary) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.dateofjoining = dateofjoining;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return this.designation.getDesignation();
	}

	public String getDateofjoining() {
		return dateofjoining;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public int compareTo(EmployeeSpec o) {
		if(this.id == o.getId()) {
			return 0;
		}
		else if(this.id > o.getId()) {
			return 1;
		}
		return -1;
	}


	
	
}

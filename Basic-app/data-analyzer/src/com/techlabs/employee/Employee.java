package com.techlabs.employee;

import com.techlabs.constant.Designation;

public class Employee implements Comparable<Employee>{

	private int id;
	private String name;
	private Designation designation;
	private String dateofjoining;
	private int salary;
	private String departmentid;
	private String managerid;
	private String commission;
	
	public Employee(int id, String name, Designation designation, String dateofjoining, int salary, String departmentid,
			String managerid, String commision) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.dateofjoining = dateofjoining;
		this.salary = salary;
		this.departmentid = departmentid;
		this.managerid = managerid;
		this.commission = commision;
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



	public int getDepartmentid() {
		if(departmentid.equalsIgnoreCase("NULL")) {
			return 0;
		}
		return Integer.parseInt(departmentid);
	}



	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}



	public int getManagerid() {
		if(managerid.equalsIgnoreCase("NULL")) {
			return 0;
		}
		return Integer.parseInt(managerid);
	}



	public void setManagerid(int managerid) {
		this.managerid = Integer.toString(managerid);
	}



	public int getCommission() {
		if(commission.equalsIgnoreCase("NULL")) {
			return 0;
		}
		return Integer.parseInt(this.commission);
	}



	public void setCommission(int commission) {
		this.commission = Integer.toString(commission);
	}



	@Override
	public int compareTo(Employee o) {
		if(this.getId() == o.getId()) {
			return 0;
		}
		else if(this.getId() > o.getId()) {
			return 1;
		}
		return -1;
	}
	
}

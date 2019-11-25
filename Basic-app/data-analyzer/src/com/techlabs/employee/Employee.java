package com.techlabs.employee;

import com.techlabs.constant.Designation;

public class Employee extends EmployeeSpec implements Comparable<Employee>{
	
	private String departmentid;
	private String managerid;
	private String commission;
	
	public Employee(int id, String name, Designation designation, String dateofjoining, int salary, String departmentid, String managerid, String commision) {
		super(id,name,designation,dateofjoining,salary);
		this.departmentid = departmentid;
		this.managerid = managerid;
		this.commission = commision;
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

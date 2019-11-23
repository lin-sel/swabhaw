package com.techlabs.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import com.techlabs.employee.Employee;

public class DataAnalyzer {
	private Fetch dataload;
	private Set<Employee> employeelist = new TreeSet<>();
	
	public DataAnalyzer(String url) throws FileNotFoundException, IOException {
		this.dataload = new Fetch(url);
		employeelist = dataload.employeelist();
	}
	
	public DataAnalyzer() throws FileNotFoundException, IOException {
		this.dataload = new Fetch("dataFile.txt");
		employeelist = dataload.employeelist();
	}
	
	public Employee maxSalariedEmployee() {
		Employee maxsalaryemployee = null ; 
		for(Employee action : employeelist) {
			if(maxsalaryemployee == null || action.getSalary() > maxsalaryemployee.getSalary()) {
				maxsalaryemployee = action;
			}
		}
		return maxsalaryemployee;
	}
	
	public int totalEmployeeByDepartment(int departmentid) {
		int totalcount = 0;
		for(Employee employee: employeelist) {
			if(employee.getDepartmentid() == departmentid) {
				totalcount += 1;
			}
		}
		return totalcount;
	}
	
	public int totalEmployeeByDesignation(String designation) {
		int totalcount = 0;
		for(Employee employee: employeelist) {
			if(employee.getDesignation().equalsIgnoreCase(designation)) {
				totalcount += 1;
			}
		}
		return totalcount;
	}
	
	public int totalEMployee() {
		return employeelist.size();
	}
	
	public Set<Employee> employeelist(){
		return employeelist;
	}
	
}

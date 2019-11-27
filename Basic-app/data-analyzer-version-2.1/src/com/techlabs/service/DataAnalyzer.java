package com.techlabs.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import com.techlabs.designation.DDesignation;
import com.techlabs.employee.Employee;

public class DataAnalyzer {
	private FileReader dataload;
	private Set<Employee> employeelist = new TreeSet<>();
	private String filename = "dataFile.txt";

	public DataAnalyzer(String url) throws FileNotFoundException, IOException {
		this.dataload = new FileReader(url);
		employeelist = dataload.employeelist();
	}

	public DataAnalyzer() throws FileNotFoundException, IOException {
		this.dataload = new FileReader(filename);
		employeelist = dataload.employeelist();
	}

	public Employee maxSalariedEmployee() {
		Employee maxsalaryemployee = null;
		for (Employee action : employeelist) {
			if (maxsalaryemployee == null
					|| action.getEmployeespec().getSalary() > maxsalaryemployee.getEmployeespec().getSalary()) {
				maxsalaryemployee = action;
			}
		}
		return maxsalaryemployee;
	}

	public int totalEmployeeByDepartment(int departmentid) {
		int totalcount = 0;
		for (Employee employee : employeelist) {
			if (employee.getDepartmentid() == departmentid) {
				totalcount += 1;
			}
		}
		return totalcount;
	}

	public int totalEmployeeByDesignation(DDesignation designation) {
		int totalcount = 0;
		for (Employee employee : employeelist) {
			if (employee.getEmployeespec().getDesignation() == designation) {
				totalcount += 1;
			}
		}
		return totalcount;
	}

	public int totalEmployee() {
		return employeelist.size();
	}

	public Set<Employee> employeelist() {
		return employeelist;
	}

}

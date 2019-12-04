package com.techlabs.console;

import java.util.Set;

import com.techlabs.employee.Employee;
import com.techlabs.fileparser.IParser;

public class HierarchyBuilder implements IHierarchyBuilder{
	@SuppressWarnings("unused")
	private IParser perser;
	private Set<Employee> employees;
	private StringBuilder hierarchy;
	
	public HierarchyBuilder(IParser perser) {
		this.perser = perser;
		this.employees = perser.readData();
		this.hierarchy = new StringBuilder("");
	}
	
	public void hierarchyBuild(Employee emp,int space) {
		hierarchy.append("   ".repeat(space)+"Designation: "+emp.getSpec().getDesignation().toString());
		hierarchy.append("\n");
		hierarchy.append("   ".repeat(space)+"Name: "+emp.getSpec().getName());
		hierarchy.append("\n");
		for(Employee employee : employees) {
			if(employee.getManagerid() == emp.getSpec().getId()) {
				hierarchyBuild(employee, space+1);
			}
		}
	}
	
	public String getHierarchy() {
		hierarchyBuild(getRoot(), 0);
		return hierarchy.toString();
	}

	public Employee getRoot() {
		for(Employee employee : employees) {
			if(employee.getManagerid() == 0) {
				return employee;
			}
		}
		return null;
	}
	
	public void printData() {
		for(Employee employee: employees) {
			System.out.println(employee.getSpec().getName());
			System.out.println(employee.getSpec().getId());
			System.out.println(employee.getSpec().getDesignation().toString());
		}
	}
	
}

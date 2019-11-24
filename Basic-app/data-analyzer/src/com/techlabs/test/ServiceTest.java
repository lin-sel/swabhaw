package com.techlabs.test;

import java.io.IOException;
import java.util.Set;

import com.techlabs.constant.Designation;
import com.techlabs.employee.Employee;
import com.techlabs.service.DataAnalyzer;

public class ServiceTest {

	public static void main(String[] args) {
		DataAnalyzer service = null;
		try {
			service = new DataAnalyzer("https://swabhav-tech.firebaseapp.com/emp.txt");
			Employee employee = service.maxSalariedEmployee();
			System.out.println("Maximum Salary Employee is "+employee.getName()+" Salary "+employee.getSalary());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		printdata(service.employeelist());
		System.out.println(totalEmployeeInDepartment(30, service));
		System.out.println(totalEmployeeInDesignation("clerk",service));
	}

	private static String totalEmployeeInDesignation(String designation, DataAnalyzer service) {
		return "Total Employee as "+designation+" "+service.totalEmployeeByDesignation(Designation.PRESIDENT);
	}

	private static String totalEmployeeInDepartment(int dept, DataAnalyzer access) {
		return "Total Employee in "+dept+" "+access.totalEmployeeByDepartment(dept);
	}

	private static void printdata(Set<Employee> dataload) {
		dataload.forEach((action) -> {
			System.out.println("Designation:"+action.getDesignation()+"\nId:"+action.getId()+"\nName:"+action.getName()+
					"\nDate of Joining:"+action.getDateofjoining()+"\nSalary:"+action.getSalary()+"\nDepartment:"+action.getDepartmentid()+
					"\nManager:"+action.getManagerid()+"\nCommision:"+action.getCommission());
			System.out.println("");
		});
	}

}

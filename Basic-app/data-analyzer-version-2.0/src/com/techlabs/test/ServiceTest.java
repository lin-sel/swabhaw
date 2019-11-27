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
			System.out.println("Maximum Salary Employee is " + employee.getEmployeespec().getName() + " Salary "
					+ employee.getEmployeespec().getSalary());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		printdata(service.employeelist());
		System.out.println(totalEmployeeInDepartment(30, service));
		System.out.println(totalEmployeeInDesignation(Designation.PRESIDENT, service));
	}

	private static String totalEmployeeInDesignation(Designation president, DataAnalyzer service) {
		return "Total Employee as " + president + " " + service.totalEmployeeByDesignation(president);
	}

	private static String totalEmployeeInDepartment(int dept, DataAnalyzer access) {
		return "Total Employee in " + dept + " " + access.totalEmployeeByDepartment(dept);
	}

	private static void printdata(Set<Employee> dataload) {
		dataload.forEach((action) -> {
			System.out.println("Designation:	" + action.getEmployeespec().getDesignation() + "\nId:		"
					+ action.getEmployeespec().getId() + "\nName:		" + action.getEmployeespec().getName()
					+ "\nDate of Joining:" + action.getEmployeespec().getDateofjoining() + "\nSalary:		"
					+ action.getEmployeespec().getSalary() + "\nDepartment:	" + action.getDepartmentid()
					+ "\nManager:	" + action.getManagerid() + "\nCommision:	" + action.getCommission());
			System.out.println("");
		});
	}

}

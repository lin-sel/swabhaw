package com.techlabs.employee.test;

import com.techlabs.employee.Analyst;
import com.techlabs.employee.Developer;
import com.techlabs.employee.Employee;
import com.techlabs.employee.Manager;

public class EmployeeTest {

	public static void main(String[] args) {
		Manager manager = new Manager("Nilesh",20000,"20/10/2000");
		Developer developer = new Developer("Alex",10000,"10/09/2003");
		Analyst analyst = new Analyst("Alex",10000,"10/09/2003");
		
		salarySlip(manager);
		salarySlip(developer);
		salarySlip(analyst);
	}

	public static void salarySlip(Employee employee) {
		System.out.println("Employee Type:"+ employee.getType()+"---------------------------------");
		System.out.println(employee.salarySlip());
	}

}

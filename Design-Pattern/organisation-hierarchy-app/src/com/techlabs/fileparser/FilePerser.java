package com.techlabs.fileparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

import com.techlabs.employee.Designation;
import com.techlabs.employee.Employee;
import com.techlabs.employee.EmployeeSpec;

public class FilePerser implements IParser {
	private String filename;
	private Set<Employee> employee;

	public FilePerser(String filename, Set<Employee> employee) {
		this.filename = filename;
		this.employee = employee;
	}

	@Override
	public Set<Employee> readData() {
		File file = new File(filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		String[] data = new String[8];
		while (sc.hasNextLine()) {
			data = sc.nextLine().split(",");
			EmployeeSpec spec = new EmployeeSpec(Integer.parseInt(data[0]), data[1].replace("'", ""),
					getDesignation(data[2].replace("'", "")), data[4], Integer.parseInt(data[5]), Integer.parseInt(data[7]));
			Employee employee = new Employee(getdata(data[6]), getdata(data[3]), spec);
			this.employee.add(employee);
		}
		return this.employee;
	}

	private int getdata(String string) {
		if (!string.equalsIgnoreCase("NULL")) {
			return Integer.parseInt(string);
		}
		return 0;
	}

	private Designation getDesignation(String string) {
		if (Designation.ANALYST.toString().equalsIgnoreCase(string)) {
			return Designation.ANALYST;
		} else if (Designation.CLERK.toString().equalsIgnoreCase(string)) {
			return Designation.CLERK;
		} else if (Designation.MANAGER.toString().equalsIgnoreCase(string)) {
			return Designation.MANAGER;
		} else if (Designation.PRESIDENT.toString().equalsIgnoreCase(string)) {
			return Designation.PRESIDENT;
		}
		return Designation.SALESMAN;
	}
}

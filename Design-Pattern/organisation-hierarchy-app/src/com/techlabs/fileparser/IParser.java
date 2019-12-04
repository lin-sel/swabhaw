package com.techlabs.fileparser;

import java.util.Set;

import com.techlabs.employee.Employee;

public interface IParser {
	Set<Employee> readData();
}

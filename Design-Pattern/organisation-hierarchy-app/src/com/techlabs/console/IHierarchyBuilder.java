package com.techlabs.console;

import com.techlabs.employee.Employee;

public interface IHierarchyBuilder {
	void hierarchyBuild(Employee emp,int space);
	String getHierarchy();
}

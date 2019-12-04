package com.techlabs.test;

import java.util.HashSet;
import com.techlabs.console.HierarchyBuilder;
import com.techlabs.console.IHierarchyBuilder;
import com.techlabs.fileparser.FilePerser;

public class Test {

	public static void main(String[] args) {
		FilePerser parser = new FilePerser("resource/employeedata.txt", new HashSet<>());
		IHierarchyBuilder console = new HierarchyBuilder(parser);
		System.out.println(console.getHierarchy());
	}

}

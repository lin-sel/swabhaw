package com.techlabs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.techlabs.designation.DDesignation;
import com.techlabs.employee.Employee;
import com.techlabs.employee.EmployeeSpec;

public class FileReader {
	
	private static Set<Employee> employeelist = new TreeSet<>();
	
	public FileReader(String filename) throws FileNotFoundException, IOException {
		employeelist = fetchFrom(filename);
	}
	
	// Fetch ad store data and store in SET.
	private Set<Employee> getDataFromSource(Scanner scanner) throws IOException{
		Scanner getdata = scanner;
		getdata.useDelimiter(",");
		int id  = 0;
		String name = null;
		DDesignation designation = null;
		String managerid = null;
		String dateofjoin  = null;
		int salary = 0;
		String commision = null;
		String deprtnum;
		while(getdata.hasNext()) {
			id = Integer.parseInt(trimString(getdata.next()));
			name = trimString(getdata.next());
			designation = getDesignation(trimString(getdata.next()));
			managerid = trimString(getdata.next());
			dateofjoin = trimString(getdata.next());
			salary = Integer.parseInt(trimString(getdata.next()));
			commision = trimString(getdata.next());
			deprtnum = trimString(getdata.nextLine());
			employeelist.add(new Employee(new EmployeeSpec(id,name, designation, dateofjoin, salary),deprtnum,managerid, commision));
		}
		getdata.close();
		return employeelist;	
	}
	
	// get Designation from string to Designation type.
	private Designation getDesignation(String trimString) {
		
	}
	
	// Trim All unnecessory Character from String. 
	private String trimString(String str) {
		StringBuffer br = new StringBuffer("");
		for(int init = 0; init < str.length(); init++) {
			if((str.charAt(init) >= 48 && str.charAt(init) <= 57 )||(str.charAt(init) >= 65 && str.charAt(init) <= 90 || str.charAt(init) >= 97 && str.charAt(init) <= 122 || str.charAt(init)=='-' && init > 0)) {
				br.append(str.charAt(init));
			}
		}
		return br.toString();
	}
	
	// Read Data from Source.
	public Set<Employee> fetchFrom(String url) throws IOException {
		if(pathIdentify(url)) {
			return getDataFromSource(new Scanner(new URL(url).openStream()));
		}
		return getDataFromSource(new Scanner(new File(url)));
	}
	
	// Return All Employee List.
	public Set<Employee> employeelist(){
		return employeelist;
	}
	
	// Path Identify url or Local Disk.
	private boolean pathIdentify(String file) {
		if(file.length() > 4 && file.startsWith("http")) {
			return true;
		}
		return false;
	}
}

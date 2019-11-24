package com.techlabs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.techlabs.constant.Designation;
import com.techlabs.employee.Employee;

public class DataReader {
	
	private static Set<Employee> employeelist = new TreeSet<>();
	
	public DataReader(String filename) throws FileNotFoundException, IOException {
		employeelist = fetchFrom(filename);
	}
	
	// Fetch ad store data and store in SET.
	private Set<Employee> fetchData(Scanner scanner) throws IOException{
		Scanner getdata = scanner;
		getdata.useDelimiter(",");
		int id  = 0;
		String name = null;
		Designation designation = null;
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
			employeelist.add(new Employee(id,name, designation, dateofjoin, salary,deprtnum,managerid, commision));
		}
		getdata.close();
		return employeelist;	
	}
	
	// get Designation from string to Designation type.
	private Designation getDesignation(String trimString) {
		if(trimString  == "ANALYST") {
			return Designation.ANALYST;
		}
		else if(trimString == "CLERK") {
			return Designation.CLERK;
		}
		else if(trimString == "MANAGER") {
			return Designation.MANAGER;
		}
		else if(trimString == "PRESIDENT") {
			return Designation.PRESIDENT;
		}
		return Designation.SALESMAN;
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
			return fetchData(new Scanner(new URL(url).openStream()));
		}
		return fetchData(new Scanner(new File(url)));
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

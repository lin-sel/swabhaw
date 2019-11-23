package com.techlabs.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.techlabs.employee.Employee;

public class Fetch {
	
	private static Set<Employee> employeelist = new TreeSet<>();
	
	public Fetch(String filename) throws FileNotFoundException, IOException {
		employeelist = fetchFrom(filename);
	}
	
	
	private Set<Employee> dataload(Scanner scanner) throws IOException{
		Scanner getdata = scanner;
		getdata.useDelimiter(",");
		int id  = 0;
		String name = null;
		String designation = null;
		String managerid = null;
		String dateofjoin  = null;
		int salary = 0;
		String commision = null;
		String deprtnum;
		while(getdata.hasNext()) {
			id = Integer.parseInt(trimString(getdata.next()));
			name = trimString(getdata.next());
			designation = trimString(getdata.next());
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
	
	private String trimString(String str) {
		StringBuffer br = new StringBuffer("");
		for(int init = 0; init < str.length(); init++) {
			if((str.charAt(init) >= 48 && str.charAt(init) <= 57 )||(str.charAt(init) >= 65 && str.charAt(init) <= 90 || str.charAt(init) >= 97 && str.charAt(init) <= 122 || str.charAt(init)=='-' && init > 0)) {
				br.append(str.charAt(init));
			}
		}
		return br.toString();
	}
	
	public Set<Employee> fetchFrom(String url) throws IOException {
		if(pathIdentifier(url)) {
			return dataload(new Scanner(new URL(url).openStream()));
		}
		return dataload(new Scanner(new File(url)));
	}
	
	public Set<Employee> employeelist(){
		return employeelist;
	}
	
	private boolean pathIdentifier(String file) {
		if(file.length() > 4 && file.startsWith("http")) {
			return true;
		}
		return false;
	}
}

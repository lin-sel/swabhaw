package com.techlabs.employee;

public abstract class Employee {
	private String name;
	protected double basicsalary;
	private int id;
	private String dateofjoin;
	private String type;
	
	public Employee(String name, double basicsal, int id, String date,String type){
		this.basicsalary = basicsal;
		this.dateofjoin = date;
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public abstract double calculateAnnualSalary();

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getDateofjoin() {
		return dateofjoin;
	}

	public String getType() {
		return this.type;
	}
	
	public abstract String salarySlip();
}

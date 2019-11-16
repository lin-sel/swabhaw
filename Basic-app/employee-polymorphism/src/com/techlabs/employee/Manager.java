package com.techlabs.employee;

public class Manager extends Employee{
	private double hra;
	private double ta;
	private double da;
	
	public Manager(String name, double basicsal, String date) {
		super(name, basicsal, (int)(Math.random()*100), date,"Manager");
		setHra();
		setTa();
		setDa();
	}
	
	public double getHra() {
		return hra;
	}

	public void setHra() {
		this.hra = (50*basicsalary)/100;
	}

	public double getTa() {
		return ta;
	}

	public void setTa() {
		this.ta = (40*basicsalary)/100;
	}

	public double getDa() {
		return da;
	}

	public void setDa() {
		this.da = (30*basicsalary)/100;
	}

	@Override
	public double calculateAnnualSalary() {
		double salary = 12 *(hra + basicsalary + ta + da);
		return salary;
	}

	@Override
	public String salarySlip() {
		return "Basic Salary: "+basicsalary+"\nHra: "+getHra()+"\nTa: "+getTa()+"\nDa: "+getDa()+"\nAnnual Salary: "+calculateAnnualSalary();
	}

}

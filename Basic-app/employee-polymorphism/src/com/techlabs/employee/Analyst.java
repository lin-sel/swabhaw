package com.techlabs.employee;

public class Analyst extends Employee{
	private double perks;
	
	public Analyst(String name, double basicsal, String date) {
		super(name, basicsal, (int)(Math.random()*100), date,"Analyst");
		setPerks();
	}
	
	public double getPerks() {
		return perks;
	}

	public void setPerks() {
		this.perks = (30*basicsalary)/100;
	}
	
	@Override
	public double calculateAnnualSalary() {
		double salary = 12 * (perks + basicsalary);
		return salary;
	}
	
	@Override
	public String salarySlip() {
		return "Basic Salary: "+basicsalary+"\nPa: "+getPerks()+"\nAnnual Salary: "+calculateAnnualSalary();
	}
}

package com.techlabs.employee;

public class Developer extends Employee{
	private double pa;
	private double bonus;
	
	public Developer(String name, double basicsal, String date) {
		super(name, basicsal, (int)(Math.random()*100), date,"Developer");
		setPa();
		setBonus();
	}
	
	
	public double getPa() {
		return pa;
	}


	public void setPa() {
		this.pa = (40*basicsalary)/100;
	}


	public double getBonus() {
		return bonus;
	}


	public void setBonus() {
		this.bonus = (30*basicsalary)/100;
	}
	
	@Override
	public String salarySlip() {
		return "Basic Salary: "+basicsalary+"\nPa: "+getPa()+"\nBonus: "+getBonus()+"\nAnnual Salary: "+calculateAnnualSalary();
	}

	@Override
	public double calculateAnnualSalary() {
		double salary = 12 *(pa + basicsalary + bonus);
		return salary;
	}

}

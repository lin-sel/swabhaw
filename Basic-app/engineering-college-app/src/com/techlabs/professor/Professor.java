package com.techlabs.professor;

import com.techlabs.person.Person;
import com.techlabs.professor.iprofessor.IStaff;

public class Professor extends Person implements IStaff{
	private double salary;
	
	public Professor(int id, String address, String dob, double salary) {
		super(id, address, dob);
		this.salary = salary;
	}

	@Override
	public double calculateSalary(double salary2) {
		return 12*(salary2+(salary*15)/100);
	}

	public double getSalary() {
		return salary;
	}
}

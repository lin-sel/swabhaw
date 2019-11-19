package com.techlabs.student;

import com.techlabs.person.Person;
import com.techlabs.student.branch.Branch;

public class Student extends Person{
	private Branch branch;

	public Student(int id, String address, String dob, Branch branc) {
		super(id, address, dob);
		branch = branc;
	}

	public Branch getBranch() {
		return branch;
	}	
}

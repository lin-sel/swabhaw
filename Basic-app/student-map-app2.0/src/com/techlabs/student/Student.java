package com.techlabs.student;

public class Student implements Comparable<Student>{
	private int rollnumber;
	private int standard;
	private String name;
	private double cgpa;
	
	public Student(int rollnumber, int standard, String name, double cgpa) {
		super();
		this.rollnumber = rollnumber;
		this.standard = standard;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	public int getRollnumber() {
		return rollnumber;
	}
	public int getStandard() {
		return standard;
	}
	public String getName() {
		return name;
	}
	public double getCgpa() {
		return cgpa;
	}
	
	@Override
	public int compareTo(Student st) {
		if(st.getRollnumber() == this.rollnumber && st.getStandard() == this.standard) {
			return 0;
		}
		else if(st.getRollnumber() > this.rollnumber) {
			return 1;
		}
		return -1;
	}
	
}

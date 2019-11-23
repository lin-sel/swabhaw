package com.techlabs.student;

public class Student implements Comparable{
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollnumber;
		result = prime * result + standard;
		return result;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (rollnumber != other.rollnumber)
//			return false;
//		if (standard != other.standard)
//			return false;
//		return true;
//	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student st = (Student) o;
			if(st.getRollnumber() == this.rollnumber && st.getStandard() == this.standard) {
				return 0;
			}
		}
		return 1;
	}
	
}

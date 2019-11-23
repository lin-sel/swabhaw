package com.techlabs.student.map;

import java.util.TreeMap;

import com.techlabs.student.Student;

public class StudentTreeMap {

	public static void main(String[] args) {
		TreeMap<Student, Student> studentlist = new TreeMap<>();
		Student student1 = new Student(101,10, "Alex",6.1);
		Student student2 = new Student(101,10, "George",6.2);
		Student student3 = new Student(100,10, "George",7.2);
		studentlist.put(student1, student1);
		studentlist.put(student2, student2);
		studentlist.put(student3, student3);
		System.out.println(studentlist.size());
	}

}

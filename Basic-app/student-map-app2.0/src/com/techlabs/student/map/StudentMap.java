package com.techlabs.student.map;

import java.util.HashMap;

import com.techlabs.student.Student;

public class StudentMap {
	
	public static void main(String[] args) {
		HashMap<Student, Student> studentlist = new HashMap<>();
		Student st1 = new Student(101,10,"Alex",6.6);
		Student st2 = new Student(101,8,"Alex",8.6);
		Student st3 = new Student(102,9,"Ram",5.6);
		Student st4 = new Student(101,9,"Rajesh",5.6);
		studentlist.put(st1, st1);
		studentlist.put(st2, st2);
		studentlist.put(st3,st3);
		studentlist.put(st4,st4);
		System.out.println(studentlist.size());
	}
}

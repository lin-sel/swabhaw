package com.techlabs.unit.test;

import java.util.ArrayList;

import com.techlabs.person.Person;
import com.techlabs.professor.Professor;
import com.techlabs.student.Student;
import com.techlabs.student.branch.Branch;

public class UnitTest {

	public static void main(String[] args) {
		ArrayList<Student> student = new ArrayList<>();
		ArrayList<Professor> professor = new ArrayList<>();
		
		addingProfessorData(professor);
		addingStudentData(student);
		printStudent(student);
		printProfessor(professor);
	}

	public static void printProfessor(ArrayList<Professor> professor) {
		System.out.println("Professor Details");
		for(Professor profobject : professor) {
			printDetails(profobject);
			System.out.println(profobject.getSalary());
		}
	}

	public static void printStudent(ArrayList<Student> student) {
		System.out.println("Student Details");
		for(Student stobject : student) {
			printDetails(stobject);
			System.out.println(stobject.getBranch());
		}
	}
	
	private static void printDetails(Person person) {
		System.out.println(person.getId());
		System.out.println(person.getAddress());
		System.out.println(person.getDob());
	}

	public static void addingStudentData(ArrayList<Student> student) {
		student.add(new Student(101,"38/G, LA","13/04/1997",Branch.CSE));
	}

	public static void addingProfessorData(ArrayList<Professor> professor) {
		professor.add(new Professor(987,"78-D, NY","10/11/1980",20000));
	}

}

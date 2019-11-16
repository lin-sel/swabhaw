package com.techlabs.man.test;

import com.techlabs.boy.Boy;
import com.techlabs.infant.Infant;
import com.techlabs.kid.Kid;
import com.techlabs.man.Man;

public class ManTest {

	public static void main(String[] args) {
		caseStudy1();
		caseStudy2();
		caseStudy3();
		caseStudy4();
		caseStudy5();
	}

	private static void caseStudy1() {
		System.out.println("Case 1 -----------------------------------");
		Man x;
		x = new Man();
		System.out.println(x.eat());
		System.out.println(x.play());
		System.out.println(x.read());
	}

	private static void caseStudy2() {
		System.out.println("Case 2 -----------------------------------");
		Boy x;
		x = new Boy();
		System.out.println(x.dance());
		System.out.println(x.eat());
		System.out.println(x.play());
		System.out.println(x.read());
	}

	private static void caseStudy3() {
		System.out.println("Case 3 ----------------------------------");
		Man x;
		x = new Boy();
		System.out.println(x.eat());
		System.out.println(x.play());
		System.out.println(x.read());
	}
	private static void caseStudy4() {
		atThePark(new Man());
		atThePark(new Boy());
		atThePark(new Kid());
		atThePark(new Infant());
	}

	private static void atThePark(Man x) {
		System.out.println("At the Park");
		System.out.println(x.play());
	}
	
	private static void caseStudy5() {
		Object x;
		x = 10;
		System.out.println(x.getClass());
		x = "String input";
		System.out.println(x.getClass());
		x = new Man();
		System.out.println(x.getClass());
	}

}

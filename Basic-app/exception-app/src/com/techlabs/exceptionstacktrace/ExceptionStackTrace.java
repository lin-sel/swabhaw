package com.techlabs.exceptionstacktrace;

public class ExceptionStackTrace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			m1();
		}
		catch(Throwable ex) {
			ex.printStackTrace();
		}
		System.out.println("Ending Program");
	}
	
	public static void m1(){
		System.out.println("Inside M1");
		m2();
	}
	
	public static void m2() {
		System.out.println("M2");
		m3();
	}
	
	public static void m3(){
		System.out.println("M3");
		throw new ArithmeticException("Exception Throwing");
	}

}

package com.techlabs.basic;

public class OverloadingTest {

	public static void main(String[] args) {
		System.out.println("String");
		System.out.println(12);
		System.out.println(12.19);
		System.out.println(12.09f);
		char ch = 'a';
		System.out.println(ch);
		
		printInfo(12.12f);
		printInfo(12.12);
		printInfo("String");
		printInfo('c');
		printInfo(12);
		printInfo(false);
	}
	
	public static void printInfo(int x) {
		System.out.println(x);
	}
	
	public static void printInfo(double x ) {
		System.out.println(x);
	}
	
	public static void printInfo(boolean x) {
		System.out.println(x);
	}
	
	public static void printInfo(float x) {
		System.out.println(x);
	}
	
	public static void printInfo(char x) {
		System.out.println(x);
	}
	
	public static void printInfo(String x) {
		System.out.println(x);
	}
}

package com.techlabs.basic;

public class RunTimeArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 0) {
			for(String i : args) {
				System.out.print(i+" ");
			}	
		}
		else {
			System.out.println("No Argument Pass At Runtime..");
		}
		System.out.println(args.length);
	}

}

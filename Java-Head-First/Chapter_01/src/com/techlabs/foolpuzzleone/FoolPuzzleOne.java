package com.techlabs.foolpuzzleone;

public class FoolPuzzleOne {
	private int iterator = 0;
	
	public void poolPuzzleOne() {
		
		while(iterator < 4) {
			
			System.out.print("a");
			if( iterator < 1) {
				System.out.print(" ");
			}
			System.out.print("n");
			if(iterator > 1) {
				System.out.print(" oyster");
				iterator = iterator + 2;
			}
			if(iterator == 1) {
				System.out.print("noys");
			}
			if(iterator < 1) {
				System.out.print("oise");
			}
			System.out.println("");
			iterator = iterator + 1;
		}
	}
	
	public static void main(String[] args) {
		FoolPuzzleOne fool = new FoolPuzzleOne();
		fool.poolPuzzleOne();
	}
}

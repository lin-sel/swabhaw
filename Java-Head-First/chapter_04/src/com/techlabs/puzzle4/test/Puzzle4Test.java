package com.techlabs.puzzle4.test;

import com.techlabs.puzzle4.puzzle.Puzzle;

public class Puzzle4Test {

	public static void main(String[] args) {
		Puzzle[] obs = new Puzzle[6];
		int y = 1;
		int x = 0;
		int result = 0;
		while (x < 6) {
			obs[x] = new Puzzle();
			obs[x].ivar = y;
			y = y * 10;
			x = x + 1;
		}
		
		x = 6;
		while(x > 0) {
			x = x - 1;
			result = result +  obs[x].dostuff(x) ;
		}
		System.out.println("result "+result);
	}

}

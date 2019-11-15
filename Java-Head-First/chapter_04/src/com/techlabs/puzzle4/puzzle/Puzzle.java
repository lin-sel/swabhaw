package com.techlabs.puzzle4.puzzle;

public class Puzzle {
	public int ivar;
	public int dostuff(int x) {
		if(ivar > 100) {
			return ivar * x;
		}
		return ivar * (5 - x);
	}
}

package com.techlabs.resultanalyzer;

public enum GameResult {
	PROGRESS, WIN, DRAW;
	
	public String toString() {
		switch(this){
		case PROGRESS:     return "Progress";
		case WIN: 		   return "win";
		case DRAW:		   return "Draw";
		}
		return null;
	}
}

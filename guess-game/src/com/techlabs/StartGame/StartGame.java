package com.techlabs.StartGame;

import com.techlabs.players.Players;
import com.techlabs.randnumgenerator.RanNumGenerate;

public class StartGame {

	private static void runGame() {
		Players p1 = new Players();
		Players p2 = new Players();
		Players p3 = new Players();
		boolean flag = false;
		RanNumGenerate autonum = new RanNumGenerate();
		while(true) {
			int sysguess = autonum.getSysGenRanNumber();
			int p1num = p1.getrandNum();
			int p2num = p2.getrandNum();
		    int p3num = p3.getrandNum();
			if(p2num == sysguess || p2num == sysguess || p2num == sysguess) {
				flag = true;
			}
			System.out.println("Player One Guess "+checkNumber(sysguess,p1num));
			System.out.println("Player Two Guess "+checkNumber(sysguess,p2num));
			System.out.println("Player Three Guess "+checkNumber(sysguess,p3num));
			
			if(flag) {
				break;
			}
		}
	}
	
	private static String checkNumber(int sys, int player) {
		if(sys == player) {
			return "Same Number so, win the game...";
		}
		else if(sys > player) {
			return "Less Number then System Guess";
		}
		return "Greater Number then System Guess";
	}
	
	public static void main(String[] args) {
		StartGame.runGame();
	}

}

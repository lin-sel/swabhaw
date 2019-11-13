package com.techlabs.gamelaunch;

import java.util.Scanner;

import com.techlabs.guessgame.GuessGame;

public class GameLaunch {

	public static void main(String[] args) {
		GuessGame guessgame = new GuessGame();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Player 1 Enter Number Between 0 to 9");
			guessgame.setPlayer1guessnumber(scanner.nextInt());
			System.out.println("Player 2 Enter Number Between 0 to 9");
			guessgame.setPlayer2guessnumber(scanner.nextInt());
			System.out.println("Player 3 Enter Number Between 0 to 9");
			guessgame.setPlayer3guessnumber(scanner.nextInt());
			String result = guessgame.mainDriver();
			if( result != "") {
				System.out.println(result+" win the Game.");
				break;
			}
		}
		scanner.close();
	}

}

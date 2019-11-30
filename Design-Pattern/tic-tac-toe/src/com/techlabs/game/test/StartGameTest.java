package com.techlabs.game.test;

import com.techlabs.gameconsole.GameConsole;

public class StartGameTest {
	
	public static void main(String []args) {
		GameConsole game = new GameConsole("Alex","George",3);
		game.playStart();
	}

}

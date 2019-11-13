package com.techlabs.guessgame;

import com.techlabs.player.Player;
import com.techlabs.player.TargetNumber;

public class GuessGame {
	private int targetnumber;
	private boolean player1;
	private boolean player2;
	private boolean player3;
	
	// TargetNumber Object Creating.
	private TargetNumber targetnumobject= new TargetNumber(); 
	
	// Player Object Creating.
	// Player1.
	private Player player1object = new Player();
	
	// Player2.
	private Player player2object = new Player();
	
	// Player3.
	private Player player3object = new Player();
		
	
	public String mainDriver() {
		targetnumber = targetnumobject.getTargetNumber();
		player1 = targetnumber == player1object.getNumber();
		player2 = targetnumber == player2object.getNumber();
		player3 = targetnumber == player3object.getNumber();
			
		if(player1) {
				return "Player 1";
		}
		else if(player2) {
			return "Player 2";
		}
		else if(player3) {
			return "Player 3";
		}
		return "";
	}



	public void setPlayer1guessnumber(int player1guessnumber) {
		player1object.setNumber(player1guessnumber);
	}

	public void setPlayer2guessnumber(int player2guessnumber) {
		player2object.setNumber(player2guessnumber);
	}


	public void setPlayer3guessnumber(int player3guessnumber) {
		player3object.setNumber(player3guessnumber);
	}
}

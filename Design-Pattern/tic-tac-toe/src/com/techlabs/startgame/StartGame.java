package com.techlabs.startgame;

import java.util.Scanner;

import com.techlabs.board.Board;
import com.techlabs.game.controller.GameController;
import com.techlabs.player.Player;
import com.techlabs.resultanalyzer.ResultAnalyzer;
import com.teclabs.marktype.MarkType;

public class StartGame {
	public void playStart(String player1, String player2, int boardsize) {
		Scanner sc = new Scanner(System.in);
		Player playerone = new Player(player1,MarkType.CIRCLE);
		Player playertwo = new Player(player2,MarkType.CROSS);
		Board board = new Board(boardsize);
		ResultAnalyzer analyzer = new ResultAnalyzer(board);
		GameController game = new GameController(board,playerone, playertwo, analyzer);
		int pl = 1;
		String winner;
		while(true) {
			System.out.println("Player "+pl+" Enter Position");
			System.out.println(board.availableCell());
			try {
				winner = game.getInput(sc.nextInt());
			}
			catch(RuntimeException ex) {
				System.err.println(ex.getMessage()+"\n");
				continue;
			}
			if(winner != null && winner != "") {
				System.out.println(winner+" has Win the Game");
				sc.close();
				break;
			}
			else if(winner == null) {
				System.out.println("Match has Draw");
				break;
			}
			System.out.println(game.getBoardFormat());
			pl = switchplayer(pl);
		}
		System.out.println(game.getBoardFormat());
	}
	
	private static int switchplayer(int pl) {
		if(pl == 1) {
			return 2;
		}
		return 1;
		
	}
}

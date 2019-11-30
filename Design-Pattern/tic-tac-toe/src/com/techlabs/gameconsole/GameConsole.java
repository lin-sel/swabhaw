package com.techlabs.gameconsole;

import java.util.Scanner;

import com.techlabs.board.Board;
import com.techlabs.board.BoardPrinter;
import com.techlabs.board.IBoard;
import com.techlabs.board.IBoardPrinter;
import com.techlabs.game.controller.GameController;
import com.techlabs.player.Player;
import com.techlabs.resultanalyzer.IResultAnalyzer;
import com.techlabs.resultanalyzer.ResultAnalyzer;
import com.teclabs.marktype.MarkType;

public class GameConsole {
	Player playerone, playertwo;
	IBoard board;
	IBoardPrinter boardprint;
	IResultAnalyzer analyzer;
	GameController game;
	
	public GameConsole(String playerone, String playertwo, int boardsize) {
		this.playerone = new Player(playerone,MarkType.CIRCLE);
		this.playertwo = new Player(playertwo,MarkType.CROSS);
		this.board = new Board(boardsize);
		this.boardprint = new BoardPrinter(this.board);
		this.analyzer = new ResultAnalyzer(this.board);
		this.game = new GameController(this.board,this.playerone, this.playertwo, this.analyzer, this.boardprint);
	}

	public void playStart() {
		Scanner sc = new Scanner(System.in);
		String winner;
		while(true) {
			System.out.println(game.getBoardOnConsole());
			System.out.println(game.getCurrentPlayer().getName()+" Turn: ");
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
		}
		System.out.println(game.getBoardOnConsole());
	}
}

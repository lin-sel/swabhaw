package com.techlabs.game.view;

import com.techlabs.board.Board;
import com.techlabs.board.BoardPrinter;
import com.techlabs.board.IBoard;
import com.techlabs.board.IBoardPrinter;
import com.techlabs.game.controller.GameController;
import com.techlabs.player.Player;
import com.techlabs.resultanalyzer.IResultAnalyzer;
import com.techlabs.resultanalyzer.ResultAnalyzer;
import com.teclabs.marktype.GameStatus;
import com.teclabs.marktype.MarkType;

public class GameRunner {
	Player playerone, playertwo;
	IBoard board;
	IBoardPrinter boardprint;
	IResultAnalyzer analyzer;
	GameController game;
	private GameStatus status;
	
	public GameRunner(String playerone, String playertwo, int boardsize) {
		this.playerone = new Player(playerone,MarkType.CIRCLE);
		this.playertwo = new Player(playertwo,MarkType.CROSS);
		this.board = new Board(boardsize);
		this.boardprint = new BoardPrinter(this.board);
		this.analyzer = new ResultAnalyzer(this.board);
		this.game = new GameController(this.board,this.playerone, this.playertwo, this.analyzer, this.boardprint);
	}

	public GameStatus playStart(int position) {
			status = GameStatus.PROGRESS;
			try {
				status = game.getInput(position);
			}
			catch(RuntimeException ex) {
			}
			return status;
	}
}

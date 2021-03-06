package com.techlabs.game.controller;

import com.techlabs.board.IBoard;
import com.techlabs.board.IBoardPrinter;
import com.techlabs.player.IPlayer;
import com.techlabs.resultanalyzer.IResultAnalyzer;
import com.teclabs.marktype.GameStatus;

public class GameController implements IGameController{
	private IBoard board;
	private IPlayer playerone;
	private IPlayer playertwo;
	private IPlayer currentPlayer;
	private IResultAnalyzer analyzer;
	private IBoardPrinter boardprint;

	public GameController(IBoard board, IPlayer playerone, IPlayer playertwo, IResultAnalyzer analyzer, IBoardPrinter boardprint) {
		this.board = board;
		this.playerone = playerone;
		this.playertwo = playertwo;
		this.analyzer = analyzer;
		this.boardprint = boardprint;
		currentPlayer = playerone;
	}
	
	@Override
	public GameStatus getInput(int position) {
		board.setBoardCell(position, currentPlayer.getMark());
		if (callAnalyzer(position)) {
			return GameStatus.WIN;
		}
		else if(!board.isAnyCellAvailable()) {
			return GameStatus.DRAW;
		}
		switchCurrentPlayer();
		return GameStatus.PROGRESS;
	}

	public String getBoardOnConsole() {
		return boardprint.boardprint();
	}

	private boolean callAnalyzer(int position) {
		return analyzer.analyzelinearly(position) || analyzer.analyzeVerticle(position)
				|| analyzer.analyzeDiagonal(position);
	}

	private void switchCurrentPlayer() {
		if (currentPlayer == playerone) {
			currentPlayer = playertwo;
			return;
		}
		currentPlayer = playerone;
	}
	
	public IPlayer getCurrentPlayer() {
		return this.currentPlayer;
	}
}

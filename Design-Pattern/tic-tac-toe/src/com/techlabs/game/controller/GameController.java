package com.techlabs.game.controller;

import com.techlabs.board.IBoard;
import com.techlabs.player.IPlayer;
import com.techlabs.resultanalyzer.IResultAnalyzer;

public class GameController implements IGameController{
	private IBoard board;
	private IPlayer playerone;
	private IPlayer playertwo;
	private IPlayer currentPlayer;
	private IResultAnalyzer analyzer;

	public GameController(IBoard board, IPlayer playerone, IPlayer playertwo, IResultAnalyzer analyzer) {
		this.board = board;
		this.playerone = playerone;
		this.playertwo = playertwo;
		this.analyzer = analyzer;
		currentPlayer = playerone;
	}
	
	@Override
	public String getInput(int position) {
		board.setBoardCell(position, currentPlayer.getMark());
		if (callAnalyzer(position)) {
			return currentPlayer.getName();
		}
		else if(!board.isAnyCellAvailable()) {
			return null;
		}
		switchCurrentPlayer();
		return "";
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
	
	public String getBoardFormat() {
		StringBuffer boardformat = new StringBuffer();
		int boardsize = board.getBoardsize();
		int coordinate = 0;
		String mark ; 
		for(int initpos = 0; initpos < boardsize; initpos++) {
			for(int row = 0; row < boardsize; row++) {
				mark = board.getBoardCell(coordinate) != null ? board.getBoardCell(coordinate).getMark().toString() : " ";
				boardformat.append(mark);
				boardformat.append(" | ");
				coordinate++;
			}
			boardformat.append("\n");
		}
		
		return boardformat.toString();
	}

}

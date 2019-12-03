package com.techlabs.board;

public class BoardPrinter implements IBoardPrinter{
	IBoard board;

	public BoardPrinter(IBoard board) {
		this.board = board;
	}
	
	@Override
	public String boardprint() {
		StringBuffer boardformat = new StringBuffer();
		int boardsize = board.getBoardsize();
		int coordinate = 0;
		String mark ; 
		for(int initpos = 0; initpos < boardsize; initpos++) {
			for(int row = 0; row < boardsize; row++) {
				mark = board.getBoardCell(coordinate) != null ? board.getBoardCell(coordinate).getMark().toString() : Integer.toString(coordinate);
				boardformat.append(mark);
				boardformat.append(" | ");
				coordinate++;
			}
			boardformat.append("\n");
		}
		
		return boardformat.toString();
	}
}

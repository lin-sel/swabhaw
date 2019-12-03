package com.techlabs.board;

import com.techlabs.cell.Cell;
import com.techlabs.cell.ICell;
import com.teclabs.marktype.MarkType;

public class Board implements IBoard{
	private ICell[] board;
	private int boardsize; 

	public Board(int size) {
		this.boardsize = size;
		this.board = new Cell[size*size];
	}
	
	public int getBoardsize() {
		return boardsize;
	}

	public void setBoardCell(int position, MarkType mark) {
		if(isAvailable(position)) {
			board[position] = new Cell(mark);
		}
	}
	
	public boolean isAvailable(int position) {
		if(board[position] == null) {
			return true;
		}
		throw new RuntimeException("Cell Already Marked");
	}
	
	public ICell getBoardCell(int position) {
		if(board.length < position) {
			throw new RuntimeException("Out of Size of Board");
		}
		return board[position];
	}
	
	public int boardlength() {
		return board.length;
	}
	
	public boolean isAnyCellAvailable() {
		for(int initpos = 0; initpos < this.boardlength(); initpos++) {
			if(board[initpos] == null) {
				return true;
			}
		}
		return false;
	}
	
	public String availableCell() {
		StringBuffer availablecell= new StringBuffer("");
		for(int initpos = 0; initpos < board.length; initpos++) {
			if(board[initpos] == null) {
				availablecell.append(" "+initpos);
			}
		}
		return availablecell.toString();
	}
}

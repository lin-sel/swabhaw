package com.techlabs.board;

import com.techlabs.cell.ICell;
import com.teclabs.marktype.MarkType;

public interface IBoard {
	int getBoardsize();
	void setBoardCell(int position, MarkType mark);
	boolean isAvailable(int position);
	ICell getBoardCell(int position);
	int boardlength();
	boolean isAnyCellAvailable();
	String availableCell();
}

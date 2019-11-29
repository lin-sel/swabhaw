package com.techlabs.board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.techlabs.cell.Cell;
import com.teclabs.marktype.MarkType;

public class BoardTest {
	
	@Test
	public void boardSizeShouldbeSame() {
		Board board = new Board(3);
		equals(3 == board.getBoardsize());
	}
	
	@Test
	public void boardLengthshouldbeSquareOfSize() {
		Board board = new Board(3);
		equals(9 == board.boardlength());
	}
	
	@Test
	public void cellShouldBeAssign() {
		Board board = new Board(3);
		board.setBoardCell(8, MarkType.CIRCLE);
		Assertions.assertThrows(RuntimeException.class,()->{
			board.isAvailable(8);
		});
	}
	
	@Test
	public void emptyPositionShouldbeAvailableForCellAssign() {
		Board board = new Board(3);
		assertTrue(board.isAvailable(5));
	}
	
	@Test
	public void throwExceptionForOutOfBoundSize() {
		Board board = new Board(3);
		assertThrows(RuntimeException.class, ()->{
			board.isAvailable(10);
		});
	}
}

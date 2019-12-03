package com.techlabs.resultanalyzer;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.techlabs.board.Board;
import com.teclabs.marktype.MarkType;

public class ResultAnalyzerTest {
	
	@Test
	public void linearAnalysis() {
		Board board = new Board(4);
		board.setBoardCell(4, MarkType.CROSS);
		board.setBoardCell(5, MarkType.CROSS);
		board.setBoardCell(6, MarkType.CROSS);
		board.setBoardCell(7, MarkType.CROSS);
		ResultAnalyzer result = new ResultAnalyzer(board);
		assertTrue(result.analyzelinearly(7));
	}
	
	@Test
	public void DiagonalAnalysis() {
		Board board = new Board(4);
		board.setBoardCell(3, MarkType.CROSS);
		board.setBoardCell(6, MarkType.CROSS);
		board.setBoardCell(9, MarkType.CROSS);
		board.setBoardCell(12, MarkType.CROSS);
		ResultAnalyzer result = new ResultAnalyzer(board);
		assertTrue(result.analyzeDiagonal(6));
	}
	
	@Test
	public void verticleAnalysis() {
		Board board = new Board(4);
		board.setBoardCell(1, MarkType.CROSS);
		board.setBoardCell(5, MarkType.CROSS);
		board.setBoardCell(9, MarkType.CROSS);
		board.setBoardCell(13, MarkType.CROSS);
		ResultAnalyzer result = new ResultAnalyzer(board);
		assertTrue(result.analyzeVerticle(5));
	}
}

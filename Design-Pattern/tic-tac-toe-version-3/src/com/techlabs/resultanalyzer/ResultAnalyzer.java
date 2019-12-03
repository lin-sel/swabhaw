package com.techlabs.resultanalyzer;

import com.techlabs.board.IBoard;
import com.teclabs.marktype.MarkType;

public class ResultAnalyzer implements IResultAnalyzer {
	IBoard resultanalyzerboard;

	public ResultAnalyzer(IBoard analyzerboard) {
		this.resultanalyzerboard = analyzerboard;
	}

	@Override
	public boolean analyzelinearly(int position) {
		int rowNum = position / resultanalyzerboard.getBoardsize();
		int initpos = rowNum * resultanalyzerboard.getBoardsize();
		int looplimit = initpos + resultanalyzerboard.getBoardsize();
		int iterator = 1;
		if (initpos == resultanalyzerboard.getBoardsize() - 1) {
			iterator = -1;
		}
		while (true) {
			if (resultanalyzerboard.getBoardCell(initpos) == null || resultanalyzerboard.getBoardCell(initpos)
					.getMark() != resultanalyzerboard.getBoardCell(position).getMark()) {
				return false;
			} else if (initpos < looplimit-1) {
				initpos = initpos + iterator;
			} else {
				break;
			}
		}
		return true;
	}

	@Override
	public boolean analyzeDiagonal(int position) {
		boolean forwardresult = false, backwardresult = false;
		if ((position % (resultanalyzerboard.getBoardsize() + 1)) == 0) {
			forwardresult = checkMarkDiagonalForward(resultanalyzerboard.getBoardsize() + 1,
					resultanalyzerboard.getBoardCell(position).getMark());
		} else if (position % (resultanalyzerboard.getBoardsize() - 1) == 0) {
			backwardresult = checkMarkDiagonalBackword(resultanalyzerboard.getBoardsize() - 1,
					resultanalyzerboard.getBoardCell(position).getMark());
		}

		return forwardresult || backwardresult;
	}

	private boolean checkMarkDiagonalBackword(int i, MarkType mark) {
		int length = i * resultanalyzerboard.getBoardsize();
		for (int initpos = i; initpos < length; initpos += i) {
			if (resultanalyzerboard.getBoardCell(initpos) == null
					|| resultanalyzerboard.getBoardCell(initpos).getMark() != mark) {
				return false;
			}
		}
		return true;
	}

	private boolean checkMarkDiagonalForward(int i, MarkType markType) {
		int length = (i - 1) * resultanalyzerboard.getBoardsize();
		for (int initpos = 0; initpos < length; initpos += i) {
			if (resultanalyzerboard.getBoardCell(initpos) == null
					|| resultanalyzerboard.getBoardCell(initpos).getMark() != markType) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean analyzeVerticle(int position) {
		int boardsize = resultanalyzerboard.getBoardsize();
		int length = resultanalyzerboard.getBoardsize() * resultanalyzerboard.getBoardsize();
		MarkType mark = resultanalyzerboard.getBoardCell(position).getMark();
		for (int initpos = position % boardsize; initpos < length; initpos += boardsize) {
			if (resultanalyzerboard.getBoardCell(initpos) == null
					|| resultanalyzerboard.getBoardCell(initpos).getMark() != mark) {
				return false;
			}
		}
		return true;
	}

}

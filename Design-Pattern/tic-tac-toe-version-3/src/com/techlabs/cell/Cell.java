package com.techlabs.cell;

import com.teclabs.marktype.MarkType;

public class Cell implements ICell{
	private MarkType mark;

	public Cell() {
		this.mark = MarkType.DEFAULT;
	}
	public Cell(MarkType mark) {
		this.mark = mark;
	}
	
	@Override
	public MarkType getMark() {
		return mark;
	}
	
	@Override
	public boolean setMark(MarkType mark) {
		if(isCellAvailable()) {
			this.mark = mark;
			return true;
		}
		return false;
	}
	
	private boolean isCellAvailable() {
		if(getMark() == MarkType.DEFAULT) {
			return true;
		}
		return false;
	}

	@Override
	public ICell getInstance() {
		return new Cell();
	}
	
	
	
}

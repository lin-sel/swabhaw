package com.techlabs.cell;

import com.teclabs.marktype.MarkType;

public interface ICell {
	MarkType getMark() ;
	boolean setMark(MarkType mark);
	ICell getInstance();
}

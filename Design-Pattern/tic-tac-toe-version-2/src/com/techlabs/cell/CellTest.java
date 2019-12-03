package com.techlabs.cell;

import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;

import com.teclabs.marktype.MarkType;

public class CellTest {
	
	@Test
	public void ifcellcreatedthenmarkshouldbenull() {
		Cell cell = new Cell();
		equals(MarkType.DEFAULT == cell.getMark());
	}
	
	@Test
	public void ifcellMarksetCircleThenMarkShouldbeCircle() {
		Cell cell = new Cell();
		cell.setMark(MarkType.CIRCLE);
		equals(MarkType.CIRCLE == cell.getMark());
	}
	
	@Test
	public void cellMarkShouldNotBeModifiedIfMarkTypeNotNull() {
		Cell cell = new Cell();
		cell.setMark(MarkType.CIRCLE);
		assertFalse(cell.setMark(MarkType.CROSS));
	}
	

}

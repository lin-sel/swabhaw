package com.techlabs.player;

import org.junit.jupiter.api.Test;

import com.teclabs.marktype.MarkType;

public class PlayerTest {
	
	@Test
	public void getSameNameOfPlayer() {
		Player player = new Player("ABC",MarkType.CIRCLE);
		equals("ABC" == player.getName());
	}
	
	public void getSameMarkTypeOfPlayer() {
		Player player = new Player("ABC",MarkType.CIRCLE);
		equals(MarkType.CIRCLE == player.getMark());
	}
}

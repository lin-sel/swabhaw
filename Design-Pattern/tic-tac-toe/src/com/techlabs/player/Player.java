package com.techlabs.player;

import com.teclabs.marktype.MarkType;

public class Player implements IPlayer{
	private String name;
	private MarkType mark;
	
	public Player(String name, MarkType mark) {
		this.name = name;
		this.mark = mark;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public MarkType getMark() {
		return mark;
	}
	
	
	
}

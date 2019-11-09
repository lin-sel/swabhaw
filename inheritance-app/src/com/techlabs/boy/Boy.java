package com.techlabs.boy;

import com.techlabs.man.Man;

public class Boy extends Man{
	public String dance() {
		return "Boy Dance ";
	}
	
	@Override
	public String play() {
		return "Boy Play ";
	}
	
	@Override
	public String eat() {
		return "Boy Eat ";
	}
}

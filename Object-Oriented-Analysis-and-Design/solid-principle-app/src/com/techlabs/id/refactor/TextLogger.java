package com.techlabs.id.refactor;

public class TextLogger implements ILogger{

	@Override
	public void log(Exception ex) {
		System.out.println(ex);
	}

}

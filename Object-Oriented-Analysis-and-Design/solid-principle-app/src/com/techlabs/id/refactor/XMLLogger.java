package com.techlabs.id.refactor;

public class XMLLogger implements ILogger{

	@Override
	public void log(Exception ex) {
		System.out.println(ex);
	}

}

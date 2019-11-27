package com.techlabs.id.violence;

public class XMLLogger extends TextLogger{
	
	@Override
	public void log(Exception ex) {
		System.out.println("XML Logger Working");
		System.out.println(ex);
	}
}

package com.techlabs.logger;

import java.util.Date;

public class Logger implements ILogger{

	@Override
	public void log() {
		System.out.println(new Date());
	}

}

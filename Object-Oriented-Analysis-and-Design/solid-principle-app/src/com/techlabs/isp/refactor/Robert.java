package com.techlabs.isp.refactor;

public class Robert implements IWork{

	@Override
	public void startWork() {
		System.out.println("Start Work.");
	}

	@Override
	public void stopWork() {
		System.out.println("Stop Work.");
	}

}

package com.techlabs.isp.violence;

public class Robert implements IWorker{

	@Override
	public void startWork() {
		System.out.println("Start Work.");
	}

	@Override
	public void stopWork() {
		System.out.println("Stop Work.");
	}

	@Override
	public void startEat() {
		throw new RuntimeException("Can not Eat");
	}

	@Override
	public void stopEat() {
		throw new RuntimeException("Can not Eat");
	}

}

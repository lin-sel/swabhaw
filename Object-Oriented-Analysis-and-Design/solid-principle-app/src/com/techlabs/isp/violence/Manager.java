package com.techlabs.isp.violence;

public class Manager implements IWorker{

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
		System.out.println("Start Eat.");
	}

	@Override
	public void stopEat() {
		System.out.println("Stop Eat.");
	}

}

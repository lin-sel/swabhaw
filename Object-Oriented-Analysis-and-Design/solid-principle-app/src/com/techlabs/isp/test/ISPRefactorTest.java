package com.techlabs.isp.test;

import com.techlabs.isp.refactor.IWork;
import com.techlabs.isp.refactor.IWorkEat;
import com.techlabs.isp.refactor.Manager;
import com.techlabs.isp.refactor.Robert;

public class ISPRefactorTest {

	public static void main(String[] args) {
		Manager manager = new Manager();
		invokeWorker(manager);
		Robert robert = new Robert();
		invokeWorker(robert);
	}

	private static void invokeWorker(IWork robert) {
		robert.startWork();
		robert.stopWork();
	}

	private static void invokeWorker(IWorkEat manager) {
		manager.startWork();
		manager.stopWork();
		manager.startEat();
		manager.stopEat();
	}

}

package com.techlabs.isp.test;

import com.techlabs.isp.violence.IWorker;
import com.techlabs.isp.violence.Manager;
import com.techlabs.isp.violence.Robert;

public class ISPViolenceTest {
	public static void main(String[] args) {
		Manager manager = new Manager();
		invokeWorker(manager);
		Robert robert = new Robert();
		invokeWorker(robert);
	}

	private static void invokeWorker(IWorker manager) {
		manager.startWork();
		manager.stopWork();
		manager.startEat();
		manager.stopEat();
	}
}

package com.techlabs.synchronize.test;

import com.techlabs.synchronize.SingletonSynchronize;

public class Test {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(SingletonSynchronize.getInstance());
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(SingletonSynchronize.getInstance());
			}
		});
		
		t1.start();
		t2.start();
	}

}

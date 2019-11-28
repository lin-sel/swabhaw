package com.techlabs.singleton.lazy.installation.test;

import com.techlabs.singleton.eager.lazy.Singleton;

public class LazyInstallationTest {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	}

}

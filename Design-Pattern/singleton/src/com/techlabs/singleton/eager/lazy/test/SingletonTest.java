package com.techlabs.singleton.eager.lazy.test;

import com.techlabs.singleton.eager.lazy.Singleton;

public class SingletonTest {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	}

}

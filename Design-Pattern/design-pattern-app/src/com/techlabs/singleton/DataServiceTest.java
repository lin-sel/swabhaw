package com.techlabs.singleton;

public class DataServiceTest {
	public static void main(String[] args) {
		DataService single = DataService.getInstance();
		single.doSomething(single);
		DataService single2 = DataService.getInstance();
		single.doSomething(single2);
	}
}

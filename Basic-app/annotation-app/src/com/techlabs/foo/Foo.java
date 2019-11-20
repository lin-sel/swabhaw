package com.techlabs.foo;

import com.techlabs.needtorefactor.NeedToRefactor;

public class Foo {
	
	@NeedToRefactor
	public void m1(){
		System.out.println("Hello");
	}
	
	public void m2(){
		System.out.println("Hello");
	}
	
	public void m3(){
		System.out.println("Hello");
	}
	
	@NeedToRefactor
	public void m4(){
		System.out.println("Hello");
	}
}

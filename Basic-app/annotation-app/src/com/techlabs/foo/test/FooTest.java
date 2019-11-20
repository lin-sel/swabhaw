package com.techlabs.foo.test;

import java.lang.reflect.Method;
import com.techlabs.foo.Foo;
import com.techlabs.needtorefactor.NeedToRefactor;

public class FooTest {

	public static void main(String[] args) {
			fooAnnotationCheck(new Foo());
	}

	public static void fooAnnotationCheck(Foo foo) {
		Method[] method = Foo.class.getMethods();
		int totalmethod = 0;
		for(int i = 0 ; i < method.length; i++) {
			if(method[i].getAnnotation(NeedToRefactor.class) != null) {
				totalmethod += 1;
				System.out.println(method[i]);
			}
		}
		System.out.println("Total method Need to Refactor "+totalmethod);
	}
}

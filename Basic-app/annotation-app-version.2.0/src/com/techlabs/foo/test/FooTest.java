package com.techlabs.foo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.techlabs.foo.Foo;

public class FooTest {

	public static void main(String[] args) {
		int pass = 0;
		int fail = 0;
		Foo foo = new Foo();
		Method []methods = Foo.class.getMethods();
		for(Method method : methods) {
			if(method.getGenericReturnType() == boolean.class) {
				try {
					if((boolean) method.invoke(foo)) {
						pass += 1;
					}
					else {
						fail += 1;
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				}
			}
		}
		System.out.println("Pass "+pass);
		System.out.println("Fail "+fail);
	}

}

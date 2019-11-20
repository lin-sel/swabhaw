package com.techlabs.foo;

import com.techlabs.unit.testcase.UnitTestCase;

public class Foo {
	
	@UnitTestCase
	public boolean m1() {
		return true;
	}
	
	@UnitTestCase
	public boolean m2() {
		return true;
	}
	
	@UnitTestCase
	public boolean m3() {
		return false;
	}
	
	@UnitTestCase
	public boolean m4() {
		return true;
	}
}

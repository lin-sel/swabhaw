package com.techlabs.method.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techlabs.method.list.MethodList;

public class MethodTest {
	@Test
	public void testrun() {
		MethodList method = new MethodList();
		int[] arr = {10,4,90};
		assertEquals(10,method.secondMaxValue(arr));
		assertEquals(true,method.isEquallength("ABCD", "XYZA"));
	}
}

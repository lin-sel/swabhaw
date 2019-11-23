package com.techlabs.unit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techlabs.calculate.Calculator;

public class UnitTest {
	@Test
	public void add_positiveParameter_return_positiveNumber (){
		Calculator calculator = new Calculator();
		assertEquals(10, calculator.add(5, 5));
	}
	
	// Throwing Exception
	@Test(expected = RuntimeException.class)
	public void add_negativeParameter_Throw_RuntimeException() {
		Calculator calculator = new Calculator();
		calculator.add(-5, -5);
	}
	
}

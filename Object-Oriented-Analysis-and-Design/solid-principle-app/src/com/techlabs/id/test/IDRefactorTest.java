package com.techlabs.id.test;

import com.techlabs.id.refactor.TaxCalculator;
import com.techlabs.id.refactor.TextLogger;
import com.techlabs.id.refactor.XMLLogger;

public class IDRefactorTest {
	public static void main(String[] args) {
		TaxCalculator taxcal = new TaxCalculator(new XMLLogger());
		System.out.println(taxcal.taxCalculate(12, 0));
	}
}

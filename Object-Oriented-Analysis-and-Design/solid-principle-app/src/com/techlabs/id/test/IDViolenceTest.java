package com.techlabs.id.test;

import com.techlabs.id.violence.TaxCalculator;
import com.techlabs.id.violence.TextLogger;

public class IDViolenceTest {

	public static void main(String[] args) {
		TaxCalculator taxcal = new TaxCalculator(new TextLogger());
		System.out.println(taxcal.calculate(12, 0));
	}
}

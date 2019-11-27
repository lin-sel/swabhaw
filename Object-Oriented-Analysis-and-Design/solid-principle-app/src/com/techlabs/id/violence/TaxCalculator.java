package com.techlabs.id.violence;

public class TaxCalculator {
	private TextLogger logger;
	
	public TaxCalculator(TextLogger logger) {
		this.logger = logger;
	}

	public int calculate(Object a, Object b) {
		try {
			return (int)a / (int)b;
		}
		catch(ArithmeticException ex) {
			logger.log(ex);
		}
		catch(Exception ex) {
			logger.log(ex);
		}
		return -1;
	}
}

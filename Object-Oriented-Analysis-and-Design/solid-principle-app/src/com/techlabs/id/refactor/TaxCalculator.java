package com.techlabs.id.refactor;

public class TaxCalculator {
	private ILogger logger;

	public TaxCalculator(ILogger logger) {
		this.logger = logger;
	}
	
	public int taxCalculate(Object a, Object b) {
		try {
			return (int)a / (int)b;
			
		}
		catch(Exception ex) {
			logger.log(ex);
			return -1;
		}
	}
	
	
	
}

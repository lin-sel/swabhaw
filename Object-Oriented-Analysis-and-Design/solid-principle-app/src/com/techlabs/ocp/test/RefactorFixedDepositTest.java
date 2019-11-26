package com.techlabs.ocp.test;

import com.techlabs.ocp.festivaltype.Holi;
import com.techlabs.ocp.refactor.FixedDeposit;

public class RefactorFixedDepositTest {
	public static void main(String[] args) {
		FixedDeposit fixeddeposit = new FixedDeposit("ABC",100000,10,new Holi());
		System.out.println(fixeddeposit.simpleInterest());
	}
}

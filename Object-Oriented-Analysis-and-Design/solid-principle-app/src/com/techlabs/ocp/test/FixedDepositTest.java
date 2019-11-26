package com.techlabs.ocp.test;

import com.techlabs.ocp.violence.FestivalType;
import com.techlabs.ocp.violence.FixedDeposit;

public class FixedDepositTest {

	public static void main(String[] args) {
		FixedDeposit fixeddeposit = new FixedDeposit("ABC",100000,10,FestivalType.NORMAL);
		System.out.println(fixeddeposit.simpleInterest());
	}

}

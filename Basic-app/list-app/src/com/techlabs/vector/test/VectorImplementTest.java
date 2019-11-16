package com.techlabs.vector.test;

import com.techlabs.vector.service.VectorImplement;

public class VectorImplementTest {
	public static void main(String[] args) {
		VectorImplement vector = new VectorImplement(5,3);
		vector.addData("10");
		vector.addData("20");
		vector.addData("30");
		System.out.println(vector.getData(2));
		vector.removeData("10");
		vector.replace(0,"90");
	}
}

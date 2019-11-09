package com.techlabs.set.test;

import java.util.HashSet;
import java.util.Set;

import com.techlabs.set.SetList;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetList set = new SetList();
		Set<Integer> setdata = new HashSet<>();
		set.addValue(11);
		set.addValue(12);
		set.addValue(13);
		set.removeData(12);
		set.updateValue(13, 15);
		setdata = set.getAllData();
		System.out.println(setdata);
	}

}

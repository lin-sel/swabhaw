package com.techlabs.set;

import java.util.HashSet;

public class SetList {
	
	private HashSet<Integer> set = new HashSet<>();
	
	public boolean addValue(int data) {
		return set.add(data);
	}

	public void updateValue(int olddata, int newdata) {
		for(Object setdata : set) {
			if(setdata.equals(olddata)) {
				set.remove(olddata);
				set.add(newdata);
			}
		}
	}
	
	public void removeData(int index) {
		set.remove(index);
	}
	
	public HashSet<Integer> getAllData() {
		return set;
	}
}

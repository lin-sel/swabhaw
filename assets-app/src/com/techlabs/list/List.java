package com.techlabs.list;

import java.util.ArrayList;

public class List {
	
	private ArrayList<Integer> datalist = new ArrayList<Integer>();
	
	
	public boolean addValue(int data) {
		return datalist.add(data);
	}
	
	public void updateValue(int index, int data) {
		datalist.add(index,data);
	}
	
	public void removeData(int index) {
		datalist.remove(index);
	}
	
	public Integer getDataAtIndex(int index) {
		return datalist.get(index);
	}
	
	public ArrayList<Integer> getAllData() {
		return datalist;
	}
}

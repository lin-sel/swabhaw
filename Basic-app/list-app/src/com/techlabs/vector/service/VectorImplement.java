package com.techlabs.vector.service;

import java.util.Vector;

public class VectorImplement {
	private Vector<String> vector;
	public VectorImplement(int initiallength, int increment) {
		vector = new Vector<String>(initiallength,increment);
	}
	
	public void addData(String data) {
		vector.add(data);
	}
	
	public String getData(int index) {
		return vector.get(index);
	}
	
	public void replace(int index,String data) {
		vector.set(index, data);
	}
	
	public void removeData(String data) {
		vector.remove(data);
	}
}

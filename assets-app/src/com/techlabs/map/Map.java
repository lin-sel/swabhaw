package com.techlabs.map;

import java.util.HashMap;

public class Map {
	
	private HashMap<Integer,Integer> hashmap = new HashMap<>();
	static int index = 0;
	
	public Map(){
		index += 1;
	}
	
	public boolean addValue(int data) {
		Integer status = hashmap.put(index,data);
		index += 1;
		if(status != null) {
			return true;
		}
		return false;
	}
	
	public void updateValue(int index, int data) {
		if(hashmap.containsKey(index)) {
			hashmap.replace(index,data);
		}
		else {
			hashmap.put(index,data);
		}
	}
	
	public void removeData(int index) {
		hashmap.remove(index);
	}
	
	public Integer getDataAtIndex(int index) {
		return hashmap.get(index);
	}
	
	public HashMap<Integer,Integer> getAllData() {
		return hashmap;
	}
	
	public int hashmapSize() {
		return hashmap.size();
	}
	
	public boolean isEmpty() {
		return hashmap.isEmpty();
	}
}

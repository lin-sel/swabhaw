package com.techlabs.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapClass {
	private HashMap<String, String> testlist = new HashMap<>();
	
	public MapClass(String key, String value){
		testlist.put(key,value);
	}
	
	public void addData(String key, String value) {
		testlist.put(key, value);
	}
	
	public void updateData(String key,String value, String updatevalue) {
		if(testlist.containsKey(key)) {
			if(testlist.get(key) == value) {
				testlist.put(key,updatevalue);
			}
		}
	}
	
	public void updateData(String key,String updatevalue) {
		if(testlist.containsKey(key)) {
			testlist.replace(key, updatevalue);
		}
	}
	
	public void deleteData(String key) {
		testlist.remove(key);
	}
	
	public void deleteData(String key, String value) {
		testlist.remove(key,value);
	}
	
	public boolean searchKey(String key) {
		return testlist.containsKey(key);
	}
	
	public boolean searchValue(String value) {
		return testlist.containsValue(value);
	}
	
	public String returnKey(String value) {
		for(Entry<String, String> entry : testlist.entrySet()) {
			if(entry.getValue() == value) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public String returnValue(String key) {
		return testlist.get(key);
	}
	
	public Map<String,String> allData(){
		return testlist;
	}
}

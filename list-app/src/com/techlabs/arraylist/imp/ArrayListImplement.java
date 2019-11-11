package com.techlabs.arraylist.imp;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListImplement {
	private ArrayList<String> arraylist = new ArrayList<>();
	
	public boolean addData(String data) {
		return arraylist.add(data);
	}
	
	public void addDatas(String[] datas) {
		arraylist.addAll(arraylist);
	}
	
	public void addAllDataAtPosition(int index, Collection<? extends String> datas) {
		arraylist.addAll(index, datas);
	}
	
	public void removeData(String data) {
		arraylist.remove(data);
	}
	
	public void removeDataFromIndex(int index) {
		arraylist.remove(index);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> cloneArrayList() {
		return (ArrayList<String>) arraylist.clone();
	}
	
	public void clearArrayList() {
		arraylist.clear();
	}
	
	public boolean containData(String data) {
		return arraylist.contains(data);
	}
	
	public int size() {
		return arraylist.size();
	}
}

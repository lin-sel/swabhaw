package com.techlabs.linkedlist.imp;

import java.util.LinkedList;

public class LinkedListImplement {
	LinkedList<String> linkedlist = new LinkedList<>();
	
	public boolean addData(String data) {
		return linkedlist.add(data);
	}
	
	public boolean removeData(String index) {
		return linkedlist.remove(index);
	}
	
	public void update(int index,String data) {
		linkedlist.set(index, data);
	}
	
	public String readData(int index) {
		return linkedlist.get(index);
	}
}

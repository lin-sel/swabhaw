package com.techlabs.iterator;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Itearator{
	private PriorityQueue<Integer> queue = new PriorityQueue<>();
	Iterator<Integer> iterate = queue.iterator();
	
	public void addData(Integer Data) {
		queue.add(Data);
	}
	
	public Integer search(Integer data) {
		Integer search;
		while(iterate.hasNext()) {
			if((search = iterate.next()) == data) {
				return search;
			}
		}
		return null;
	}
	
	public PriorityQueue<Integer> getlist(){
		return queue;
	}
	
	public void removeData(Integer data) {
		while(iterate.hasNext()) {
			if(iterate.next() == data) {
				iterate.remove();
			}
		}
	}
}

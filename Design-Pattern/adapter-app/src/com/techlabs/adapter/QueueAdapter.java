package com.techlabs.adapter;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueAdapter<T> implements IQueue<T>{
	private LinkedList<T> list ;

	public QueueAdapter() {
		this.list = new LinkedList<T>();
	}

	@Override
	public void enqueue(T t) {
		list.addLast(t);;
	}

	@Override
	public T dequeue() {
		return list.removeFirst();
	}

	@Override
	public int count() {
		return list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}


	
	
}

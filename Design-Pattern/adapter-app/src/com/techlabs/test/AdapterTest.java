package com.techlabs.test;

import com.techlabs.adapter.IQueue;
import com.techlabs.adapter.QueueAdapter;

public class AdapterTest {

	public static void main(String[] args) {
		IQueue<Integer> queue = new QueueAdapter<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println("First: "+queue.dequeue());
		for(Integer item : queue) {
			System.out.println(item);
		}
	}

}

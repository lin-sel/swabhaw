package com.techlabs.adapter;

public interface IQueue<T> extends Iterable<T>{
	void enqueue(T t);
	T dequeue();
	int count();
}

package com.techlabs.node;

public class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node(T t) {
		data = t;
		this.next = null;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}
	
	
	
}

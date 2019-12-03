package com.techlabs.node.list;

import com.techlabs.node.*;

public class NodeList<T> {
	private Node<T> rootNode;
	
	public void add(Node<T> node) {
		if(rootNode == null) {
			this.rootNode = node;
			return;
		}
		else {
			Node<T> temp = rootNode;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext(node);
			return;
		}
	}
	
	public void addAtFirst(Node<T> node) {
		if(this.rootNode != null) {
			node.setNext(rootNode);
			this.rootNode = node;
			return;
		}
		this.rootNode = node;
	}
	
	public void addAtLast(Node<T> node) {
		this.add(node);
	}
	
	public void addAtPosition(Node<T> node, int position) {
		int size = this.listSize();
		position = position - 2;
		if(position < size) {
			Node<T> rootnode = this.rootNode; 
			while(position > 0) {
				size--;
				rootnode = rootnode.getNext();
			}
			Node<T> temp = rootnode.getNext();
			rootnode.setNext(node);
			rootnode.getNext().setNext(temp);
			this.rootNode = rootnode;
			return ;
		}
		throw new IndexOutOfBoundsException("Invalid Index");
	}
	
	
	// Remove Element
	public void removeLast() {
		Node<T> node = this.rootNode;
		while(node.getNext().getNext() != null) {
			node = node.getNext();
		}
		node.setNext(null);
	}
	
	public void removeFirst() {
		this.rootNode = this.rootNode.getNext();
	}
	
	public void remove(int index) {
		int listsize = this.listSize();
		if(index == listsize) {
			this.removeLast();
			return;
		}
		else if(index == 1) {
			this.removeFirst();
			return;
		}
		else if(index < listsize){
			Node<T> node = this.rootNode;
			while(index-2 >= 0) {
				node.setNext(node.getNext().getNext());
				return ;
			}
		}
		throw new IndexOutOfBoundsException("Invalid Index");
	}
	
	public void remove(T value) {
		Node<T> node = this.rootNode;
		if(node.getData().equals(value)) {
			this.removeFirst();
		}
		else {
			while(node.getNext() != null && !node.getNext().getData().equals(value)) {
				node = node.getNext();
			}
			if(node.getNext().getData().equals(value)) {
				node.setNext(node.getNext().getNext());
				return ;
			}
			throw new RuntimeException("Value Not Found");
		}
	}
	
	public String printList() {
		return this.printfromNode(rootNode);
	}
	
	public String printfromNode(Node<T> node) {
		StringBuffer st = new StringBuffer("");
		while(node != null) {
			st.append(node.getData());
			node = node.getNext();
			st.append(" ");
		}
		return st.toString();
	}
	
	public int listSize() {
		Node<T> node = rootNode;
		int size = 0;
		if(rootNode == null) {
			return 0;
		}
		else {
			while(node != null) {
				size++;
				node = node.getNext();
			}
		}
		return size;
	}
	

}

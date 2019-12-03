package com.techlabs.test;

import com.techlabs.node.Node;
import com.techlabs.node.list.NodeList;

public class ListTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		NodeList<Integer> test = new NodeList<Integer>();
		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(30);
		Node<Integer> node3 = new Node<>(40);
		Node<Integer> node4 = new Node<>(50);
		
		test.add(node1);
		test.add(node2);
		test.add(node3);
		test.add(node4);
		test.addAtFirst(new Node<Integer>(100));
		test.addAtPosition(new Node<Integer>(20), 2);
		System.out.println("Size: "+test.listSize()+" ==> "+test.printList());
		test.removeLast();
		System.out.println("Size: "+test.listSize()+" ==> "+test.printList());
		test.removeFirst();
		System.out.println("Size: "+test.listSize()+" ==> "+test.printList());
		test.remove(2);
		System.out.println("Size: "+test.listSize()+" ==> "+test.printList());
		test.remove(new Integer(40));
		System.out.println("Size: "+test.listSize()+" ==> "+test.printList());
	}
}

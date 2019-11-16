package com.techlabs.linkedlist.test;

import com.techlabs.linkedlist.imp.LinkedListImplement;

public class LinkedListImplementTest {
	public static void main() {
		LinkedListImplement linkedlist = new LinkedListImplement();
		linkedlist.addData("12");
		linkedlist.readData(0);
		linkedlist.removeData("12");
		linkedlist.update(0, "10");
	}

}

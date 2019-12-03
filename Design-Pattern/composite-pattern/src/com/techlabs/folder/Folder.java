package com.techlabs.folder;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.storeitem.IStoreItem;

public class Folder implements IStoreItem{
	private String name;
	private List<IStoreItem> children;
	private int level = 1;
	
	
	public Folder(String name) {
		this.name = name;
		this.children = new ArrayList<IStoreItem>();
	}

	public void add(IStoreItem item) {
		children.add(item);
	}
	
	@Override
	public void display() {
		printlevel();
		System.out.println(this.name);
		for(IStoreItem item : children) {
			item.display();
		}
	}

	public List<IStoreItem> getChildren() {
		return children;
	}	
	
	private void printlevel() {
		for(int i = 0; i < this.level ; i++) {
			System.out.print(" ");
		}
	}
}

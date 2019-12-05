package com.techlabs.folder;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.storeitem.IStoreItem;

public class Folder implements IStoreItem{
	private String name;
	private List<IStoreItem> children;
	private static int level = 0;
	
	
	public Folder(String name) {
		this.name = name;
		this.children = new ArrayList<IStoreItem>();
	}

	public void add(IStoreItem item) {
		children.add(item);
	}
	
	@Override
	public void display() {
		System.out.println(" ".repeat(level)+this.name);
		for(IStoreItem item : children) {
			System.out.print(" ".repeat(level+1));
			item.display();
		}
	}

	public List<IStoreItem> getChildren() {
		return children;
	}	
}

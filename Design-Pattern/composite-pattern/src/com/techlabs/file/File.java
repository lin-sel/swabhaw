package com.techlabs.file;

import com.techlabs.storeitem.IStoreItem;

public class File implements IStoreItem{
	private String name;
	private String extension;
	private int size;
	private static int level = 1;
	
	public File(String name, String extension, int size) {
		this.name = name;
		this.extension = extension;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public String getExtension() {
		return extension;
	}

	public int getSize() {
		return size;
	}

	@Override
	public void display() {
		System.out.println("  ".repeat(level)+""+this.name+this.extension+" "+this.size);		
	}
}

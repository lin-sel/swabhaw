package com.techlabs.composite.Test;

import com.techlabs.file.File;
import com.techlabs.folder.Folder;

public class CompositeTest {

	public static void main(String[] args) {
		File file1 = new File("Iron Man",".mp4",1080);
		File file2 = new File("Another Life",".avi",720);
		File fil3 = new File("Dracula Untold",".mp4",1080);
		File file4 = new File("IT",".avi",720);
		File file5 = new File("Untitle",".mp4",1080);
		Folder scifi = new Folder("Scifi");
		scifi.add(file1);
		scifi.add(file2);
		Folder horror = new Folder("Horror");
		horror.add(fil3);
		horror.add(file4);
		Folder root = new Folder("Root");
		root.add(scifi);
		root.add(horror);
		root.add(file5);
		root.display();
	}

}

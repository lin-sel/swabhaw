package com.techlabs.file;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class MainHandler {

	public static void main(String[] args) throws IOException {
		String str = "First File Creating Contains Version2";
		writeIntoFile(str,"Text");
		str = "New Containts for File....";
		writeIntoFile(str,"Text");	
		readFile("Text");
	}
	
	private static void writeIntoFile(String str, String filename) throws IOException {
        BufferedWriter fw = new BufferedWriter( 
                new FileWriter(filename+".txt", true)); 
		if(endChar(filename) == 0.0) {
			fw.write(str);
		}
		else {
	        fw.write(str); 
		}
		fw.close();
	}
	
	private static void readFile(String filename) throws IOException {
		int ch;
		try {
			FileReader fr = new FileReader(filename+".txt");
			while((ch = fr.read())!= -1) {
				System.out.print((char)ch);
			}
			fr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found.");
		}
	}
	
	private static long endChar(String filename) {
		
		File object = new File(filename+".txt");
		if(object.exists()) {
			return object.length();
		}
		
		return 0;
	}

}

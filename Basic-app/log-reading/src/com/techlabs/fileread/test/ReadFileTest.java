package com.techlabs.fileread.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.techlabs.fileread.FileRead;

public class ReadFileTest {

	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> logdata = new ArrayList<>();
		FileRead fileread = new FileRead();
		logdata = fileread.readFile(logLevel(args[1]));
		for(String message : logdata) {
			System.out.println(message);
		}
	}
	
	private static String logLevel(String flag) {
		
		if("e".equalsIgnoreCase(flag)) {
			return "error";
		}
		else if("i".equalsIgnoreCase(flag)) {
			return "info";
		}
		return "warning";
	}

}

package com.techlabs.fileread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
	public ArrayList<String> readFile(String status) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("db_app.log"));
		ArrayList<String> loglist = new ArrayList<>();
		scanner.useDelimiter(" - ");
		String datetime, error, message;
		while(scanner.hasNext()) {
			datetime = scanner.next();
			error = scanner.next();
			message = scanner.nextLine();
			if(status.equalsIgnoreCase(error.toLowerCase().trim())) {
				loglist.add(message);
			}
		}
		scanner.close();
		return loglist;
	}
}


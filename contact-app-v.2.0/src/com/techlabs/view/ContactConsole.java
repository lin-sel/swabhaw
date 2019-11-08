package com.techlabs.view;

import java.io.IOException;
import java.util.Scanner;

import com.techlabs.service.ContactService;

public class ContactConsole {
	
	public void startApp() throws ClassNotFoundException, IOException {
		ContactService service = new ContactService();
		service.deSerializedata();
		while(true) {
			System.out.println("Enter Choice....");
			System.out.println("1. Add Contact.");
			System.out.println("2. View Contact");
			System.out.println("3. Total Contact");
			System.out.println("4. Exit App");
			Scanner scan = new Scanner(System.in);
			switch(scan.nextInt()) {
			case 1:
				service.storeContact();
				break;
				
			case 2:
				service.viewContact();
				break;
				
			case 3:
				System.out.println("Total Contact Store: "+service.getTotalContact());
				break;
				
			case 4:
				service.serializeData();
				System.out.println("Closing App....");
				System.exit(0);
				scan.close();
				break;
				
			default:
				System.out.println("Wrong Choice.");
			}
		}
	}
}

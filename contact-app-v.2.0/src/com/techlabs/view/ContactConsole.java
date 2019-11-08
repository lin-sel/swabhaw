package com.techlabs.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.techlabs.model.Contact;
import com.techlabs.service.ContactService;

public class ContactConsole {
	
	public void startApp() throws ClassNotFoundException, IOException {
		ContactService service = new ContactService();
		if(service.initService()) {
			while(true) {
				System.out.println("Enter Choice....");
				System.out.println("1. Add Contact.");
				System.out.println("2. View Contact");
				System.out.println("3. Total Contact");
				System.out.println("4. Exit App");
				Scanner scan = new Scanner(System.in);
				switch(scan.nextInt()) {
				case 1:
					String firstname;
					String lastname;
					String phonenumber;
					int group;
					System.out.println("Enter First Name: ");
					firstname = scan.next(); 
					System.out.println("Enter Last Name: ");
					lastname = scan.next(); 
					System.out.println("Enter Phone Number:");
					phonenumber = scan.next(); 
					System.out.println("Set Group:");
					System.out.println("1. Personal");
					System.out.println("2. Office");
					System.out.println("3. Home");
					group = scan.nextInt(); 
					boolean status = service.storeContact(firstname, lastname, phonenumber, group);
					if(status) {
						System.out.println("Contact Added Successfully.....");
					}else {
						System.out.println("Some error ........");
					}
					break;
					
				case 2:
					viewContact(service);
					break;
					
				case 3:
					System.out.println("Total Contact Store: "+service.getTotalContact());
					break;
					
				case 4:
					if(service.exitService()) {
						System.out.println("Clossing Successfully...");
					}
					else {
						System.out.println("Clossing With Some Error...");
					}
					System.exit(0);
					scan.close();
					break;
					
				default:
					System.out.println("Wrong Choice.");
				}
			}
		}
		else {
			System.out.println("Failed to start Service.........");
		}
	}
	
	public void viewContact(ContactService service) {
		ArrayList<Contact> contactdata = new ArrayList<>();
		contactdata = service.viewContact();
		for(Contact contactlist: contactdata) {
			System.out.println("First Name: "+contactlist.getFirstname());
			System.out.println("Last Name: "+contactlist.getLastname());
			System.out.println("Phone Number: "+contactlist.getPhonenumber());
			System.out.println("Group: "+contactlist.getGroup());
			sys
		}
	}
}

package com.techlabs.contact.view;

import java.util.Scanner;

import com.techlabs.contact.controller.Controller;
import com.techlabs.contactgroup.ContactGroup;

public class ContactStore {
	
	public Controller storeContact() {
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();
		
		System.out.println("Enter First Name: ");
		controller.setFirstname(scanner.nextLine());
		
		System.out.println("Enter Last Name: ");
		controller.setLastname(scanner.nextLine());
		
		System.out.println("Enter Phone Number Name: ");
		controller.setPhonenumber(scanner.nextLine());
		
		System.out.println("Enter Group Option:");
		System.out.println("1. Office");
		System.out.println("2. Home");
		controller.setGroup(getControllerContatcGroup(scanner.nextInt()));
		
		scanner.close();
		return controller;
	}
	
	private ContactGroup getControllerContatcGroup(int option) {
		
		if(option == 2) {
			return ContactGroup.Home;
		}
		
		return ContactGroup.Office; 
	}
}

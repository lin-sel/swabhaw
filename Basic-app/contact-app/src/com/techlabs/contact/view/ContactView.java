package com.techlabs.contact.view;

import com.techlabs.contact.controller.Controller;

public class ContactView {
	
	public void getContact(Controller controller) {
		
		System.out.println("Name: "+controller.getName());
		
		System.out.println("Phone Number: "+controller.getPhonenumber());
		
		System.out.println("Group: "+controller.getGroup());
		
		System.out.println("Total COntact Strore: "+Controller.getCounttotalnumber());
		
	}
}

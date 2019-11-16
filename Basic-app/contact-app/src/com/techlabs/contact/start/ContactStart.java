package com.techlabs.contact.start;

import com.techlabs.contact.controller.Controller;
import com.techlabs.contact.view.ContactStore;
import com.techlabs.contact.view.ContactView;

public class ContactStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactStore contactstore = new ContactStore();
		ContactView contactview = new ContactView();
		Controller controller2;
		controller2 = contactstore.storeContact();
		contactview.getContact(controller2); 
	}

}

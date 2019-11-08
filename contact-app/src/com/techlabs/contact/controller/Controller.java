package com.techlabs.contact.controller;

import com.techlabs.contact.Contact;
import com.techlabs.contactgroup.ContactGroup;

public class Controller extends Contact{
	
	public void setFirstname(String firstname) {
		setContactFirstname(firstname);
	}
	
	public String getName() {
		return getContactName();
	}
	
	public void setLastname(String lastname) {
		setContactLastname(lastname);
	}
	
	public String getPhonenumber() {
		return getContactPhonenumber();
	}
	
	public void setPhonenumber(String phonenumber) {
		 setContactPhonenumber(phonenumber);
	}
	
	public ContactGroup getGroup() {
		return getContactGroup();
	}
	
	public void setGroup(ContactGroup group) {
		setContactGroup(group);
	}
}

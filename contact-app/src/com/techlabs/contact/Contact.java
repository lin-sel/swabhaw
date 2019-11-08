package com.techlabs.contact;

import com.techlabs.contactgroup.ContactGroup;

public class Contact {
	
	private String firstname;
	private String lastname;
	private String phonenumber;
	private ContactGroup group;
	private static int counttotalnumber = 0;
	
	
	public Contact() {
		setCounttotalnumber();
	}
	
	protected void setContactFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	protected String getContactName() {
		return firstname+" "+lastname;
	}
	
	protected void setContactLastname(String lastname) {
		this.lastname = lastname;
	}
	
	protected String getContactPhonenumber() {
		return phonenumber;
	}
	
	protected void setContactPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	protected ContactGroup getContactGroup() {
		return group;
	}
	
	protected void setContactGroup(ContactGroup group) {
		this.group = group;
	}
	
	public static int getCounttotalnumber() {
		return counttotalnumber;
	}
	
	private static void setCounttotalnumber() {
		Contact.counttotalnumber += 1 ;
	}
	
	
	
}

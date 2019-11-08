package com.techlabs.model;

import java.io.Serializable;

public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String phonenumber;
	private int totalcontact;
	private Group group;
	
	public Contact() {
		totalcontact += 1;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public int getTotalcontact() {
		return totalcontact;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
}

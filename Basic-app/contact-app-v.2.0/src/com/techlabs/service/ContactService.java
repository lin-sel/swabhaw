package com.techlabs.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.techlabs.model.Contact;
import com.techlabs.model.Group;

public class ContactService{

	private ArrayList<Contact> contactdata = new ArrayList<>();

	public boolean storeContact(String firstname, String lastname, String phonenumber, int group) {
		Contact contact = new Contact();
		contact.setFirstname(firstname);
		contact.setLastname(lastname);
		contact.setPhonenumber(phonenumber);
		contact.setGroup(setGroup(group));
		return contactdata.add(contact);
	}
	
	// COntact Data All Contact Details
	public ArrayList<Contact> viewContact() {
		return contactdata;
	}
	
	// Serialize data
	public boolean exitService() throws IOException{
		String filename = "Contact.ser";
		boolean status = false;
		try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactdata);
            oos.close();
            fos.close();
            status = true;
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            status = true;
        }
		return status;
	}
	
	// Deserialize Data
	@SuppressWarnings("unchecked")
	public boolean initService() throws ClassNotFoundException, IOException{
		String filename = "Contact.ser";
		boolean status = false;
		try
        {
            FileInputStream fos = new FileInputStream(filename);
            ObjectInputStream oos = new ObjectInputStream(fos);
            contactdata = (ArrayList<Contact>) oos.readObject();
            oos.close();
            fos.close();
            status = true;
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
		return status;
	}
	
	// Get Total Contact Store..
	public int getTotalContact(){
		return contactdata.size();
	}
	
	// Set Contact Group Type..
	private Group setGroup(int option) {
		byte option1 = 1;
		byte option2 = 2;
		if(option == option1) {
			return Group.Personal;
		}
		else if(option == option2) {
			return Group.Office;
		}
		return Group.Home;
	}
}

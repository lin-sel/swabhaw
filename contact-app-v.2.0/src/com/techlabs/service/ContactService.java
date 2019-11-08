package com.techlabs.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.techlabs.model.Contact;
import com.techlabs.model.Group;

public class ContactService{

	private ArrayList<Contact> contactdata = new ArrayList<>();

	public void storeContact() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Contact contact = new Contact();
		System.out.println("Enter First Name:");
		contact.setFirstname(scanner.nextLine());
		System.out.println("Enter Last Name:");
		contact.setLastname(scanner.nextLine());
		System.out.println("Enter Phone Number:");
		contact.setPhonenumber(scanner.nextLine());
		System.out.println("Set Group:");
		System.out.println("1. Personal");
		System.out.println("2. Office");
		System.out.println("3. Home");
		contact.setGroup(setGroup(scanner.nextInt()));
		if(contactdata.add(contact)) {
			System.out.println("Contact Added Successfully.....");
		}else {
			System.out.println("Some error ........");
		}
	}
	
	// View All Contact Details
	public void viewContact() {
		for(Contact contact : contactdata) {
			System.out.println("Name: "+contact.getFirstname()+" "+contact.getLastname());
			System.out.println("Phone Number: "+contact.getPhonenumber());
			System.out.println("Group: "+contact.getGroup());
		}
	}
	
	// Serialize data
	public void serializeData() throws IOException{
		String filename = "Contact.ser";
		try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactdata);
            oos.close();
            fos.close();
            System.out.println("Serialized Successfully...");
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
	}
	
	// Deserialize Data
	@SuppressWarnings("unchecked")
	public void deSerializedata() throws ClassNotFoundException, IOException{
		String filename = "Contact.ser";
		try
        {
            FileInputStream fos = new FileInputStream(filename);
            ObjectInputStream oos = new ObjectInputStream(fos);
            contactdata = (ArrayList<Contact>) oos.readObject();
            oos.close();
            fos.close();
            System.out.println("Deserialized Successfully...");
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
		
	}
	
	// Get Total Contact Store..
	public int getTotalContact(){
		return contactdata.size();
	}
	
	// Set Contact Group Type..
	private Group setGroup(int option) {
		if(option == 1) {
			return Group.Personal;
		}
		else if(option == 2) {
			return Group.Office;
		}
		return Group.Home;
	}
}

package com.techlabs.inventory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.techlabs.guitar.Guitar;

public class Inventory {
  private ArrayList<Guitar>guitarlist = new ArrayList<>();
  private String filename = "resource/guitarlist.ser";
  
  // Add Guitar To the list
  public void addGuitar(String serialNumber, String builder, double price, String model, String type, String backwood,String topwood) {
	  guitarlist.add(new Guitar(serialNumber,builder,price,model,type,backwood,topwood));
  }
  
  // Find Guitar..
  public Guitar getGuitar(String serialnumber) {
	  for(int i = 0; i < guitarlist.size();i++) {
		  if(guitarlist.get(i).getSerialNumber() == serialnumber)
			  return guitarlist.get(i);
	  }
	  return null;
  }
  
  // Search Guitar Based On Ideal Guitar's Parameter.
  public Guitar searchGuitar(Guitar idealguitar) {
	  for(int i = 0; i < guitarlist.size();i++) {
		  if(guitarlist.get(i).getType() == idealguitar.getType() || guitarlist.get(i).getModel() == idealguitar.getModel() || guitarlist.get(i).getBuilder() == idealguitar.getBuilder() || guitarlist.get(i).getBackwood() == idealguitar.getBackwood() || guitarlist.get(i).getTopwood() == idealguitar.getTopwood())
			  return guitarlist.get(i);
	  }
	  return null;
  }
  
  public String close() {
	  try {
		  FileOutputStream file = new FileOutputStream(filename);
		  ObjectOutputStream object = new ObjectOutputStream(file);
		  object.writeObject(guitarlist);  
		  file.close();
		  object.close();
	  }
	  catch(IOException exception) {
		  return "Application not Close Properly...";
	  }
	  return null;
  }
  
  @SuppressWarnings("unchecked")
  public String init() throws ClassNotFoundException {
	  try {
		  FileInputStream file = new FileInputStream(filename);
		  ObjectInputStream object = new ObjectInputStream(file);
		  guitarlist = (ArrayList<Guitar>)object.readObject();  
		  file.close();
		  object.close();
	  }
	  catch(IOException exception) {
		  return "Application not initialized Properly please reboot application again.";
	  }
	  return null;
  }
}


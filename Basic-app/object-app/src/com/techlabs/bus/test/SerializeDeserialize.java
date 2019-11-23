package com.techlabs.bus.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.techlabs.bus.Bus;

public class SerializeDeserialize {

	public static void main(String[] args) {
		Bus bus = new Bus();
		SerializeDeserialize classobject = new SerializeDeserialize();
		classobject.terminate(bus);
		Bus newobj = classobject.init();
		System.out.println(newobj.getColor());
	}
	
	public boolean terminate(Bus instance) {
		String filename = "file.txt";
		FileOutputStream file;
		try {
			file = new FileOutputStream(filename);
			ObjectOutputStream obj = new ObjectOutputStream(file);
			obj.writeObject(instance);
			file.close();
			obj.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Bus init() {
		String filename = "file.txt";
		FileInputStream file;
		try {
			file = new FileInputStream(filename);
			ObjectInputStream obj = new ObjectInputStream(file);
			Bus bus = (Bus)obj.readObject();
			file.close();
			obj.close();
			return bus;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

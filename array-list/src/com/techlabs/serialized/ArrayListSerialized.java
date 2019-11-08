package com.techlabs.serialized;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 
public class ArrayListSerialized 
{
	
	ArrayList<String> namesList = new ArrayList<String>();
	
	
    public static void serialized() throws Exception 
    { 
    	ArrayListSerialized arr = new ArrayListSerialized();
        arr.namesList.add("alex");
        arr.namesList.add("brian");
        arr.namesList.add("charles");
 
        try
        {
            FileOutputStream fos = new FileOutputStream("listData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arr.namesList);
            oos.close();
            fos.close();
            System.out.println("Successfully Serialized");
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
	public static void deSerialized() throws Exception 
    { 
    	ArrayListSerialized arr = new ArrayListSerialized();
        try
        {
            FileInputStream fos = new FileInputStream("listData");
            ObjectInputStream oos = new ObjectInputStream(fos);
            arr.namesList = (ArrayList<String>)oos.readObject();
            oos.close();
            fos.close();
            System.out.println("Successfully DeSerialized");
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
    
    public static void main(String args[]) throws Exception {
    	ArrayListSerialized.serialized();
    	ArrayListSerialized.deSerialized();
    }
}

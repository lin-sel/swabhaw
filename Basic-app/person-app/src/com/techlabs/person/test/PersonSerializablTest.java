package com.techlabs.person.test;

import java.io.*;

import com.techlabs.person.GenderOption;
import com.techlabs.person.Person; 
  
class PersonSerializablTest 
{ 
    public static void main(String[] args)
    {    
    	Person person = new Person("Alex",21,GenderOption.MALE);
        String filename = "Person.ser"; 
        PersonTest.printPersonDetails(person);
        person.personEat();
          
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(person); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
    } 
} 

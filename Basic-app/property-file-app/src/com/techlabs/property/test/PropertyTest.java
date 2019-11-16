package com.techlabs.property.test;

import java.io.IOException;

import com.techlabs.property.service.PropertyService;

public class PropertyTest {

	public static void main(String[] args) throws IOException{
		PropertyService prsc = new PropertyService();
		System.out.println(prsc.getVersion());
		System.out.println(prsc.getLanguage());
	}

}

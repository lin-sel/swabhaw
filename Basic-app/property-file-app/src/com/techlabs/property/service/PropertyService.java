package com.techlabs.property.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyService {
	String filename = "resource/config.properties";
	Properties property = new Properties();
	InputStream inputstream;
	
	public PropertyService() throws IOException{
		configvariable();
	}

	private void configvariable() throws IOException {
		inputstream = new FileInputStream(filename);
		if (inputstream != null) {
			property.load(inputstream);
		} else {
			throw new FileNotFoundException("property file '" + filename + "' not found in the classpath");
		}
	}
	public String getVersion() {
		return property.getProperty("version");
	}
	
	public String getLanguage() {
		return property.getProperty("language");
	}
}

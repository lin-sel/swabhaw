package com.techlabs.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.techlabs.factory.IAutoFactory;

public class FileParser {
	String filename = "resource/config.properties";
	static Properties property = new Properties();
	InputStream inputstream;
	
	
	public FileParser() {
		try {
			configSetting();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void configSetting() throws IOException {
		inputstream = new FileInputStream(filename);
		if (inputstream != null) {
			property.load(inputstream);
		} else {
			throw new FileNotFoundException("property file '" + filename + "' not found in the classpath");
		}
	}
	
	public Properties getProperties() {
		return property;
	}
}

package com.techlabs.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.techlabs.factory.IAutoFactory;

public class FactoryTest {
	String filename = "resource/config.properties";
	static Properties property = new Properties();
	InputStream inputstream;
	
	
	public FactoryTest() {
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


	public static void main(String[] args) {
		new FactoryTest();
		String factoryname = property.getProperty("car").toString();
		System.out.println(factoryname);
		IAutoFactory factory = null;
		try {
			Class<IAutoFactory> c = (Class<IAutoFactory>) Class.forName(factoryname);
			Method method = c.getDeclaredMethod("getInstance", null);
			factory = (IAutoFactory) method.invoke(null, null);
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		factory.make().start();
	}

}

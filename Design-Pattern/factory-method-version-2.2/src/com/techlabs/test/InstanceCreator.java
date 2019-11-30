package com.techlabs.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.techlabs.factory.IAutoFactory;

public class InstanceCreator {
	private Properties parse;
	public InstanceCreator(FileParser parser){
		this.parse = parser.getProperties();
	}
	public IAutoFactory getClassInstance() {
		
		String factoryname = parse.getProperty("car").toString();
		IAutoFactory factory = null;
		try {
			Class<IAutoFactory> c = (Class<IAutoFactory>) Class.forName(factoryname);
			Method method = c.getDeclaredMethod("getInstance", null);
			factory = (IAutoFactory) method.invoke(null, null);
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return factory;
	}
}

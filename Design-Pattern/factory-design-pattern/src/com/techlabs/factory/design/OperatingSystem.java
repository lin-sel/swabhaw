package com.techlabs.factory.design;

import com.techlabs.phone.Android;
import com.techlabs.phone.IOS;
import com.techlabs.phone.OS;
import com.techlabs.phone.Window;

public class OperatingSystem {
	
	public OS getInstance(String str) {
		if(str.equalsIgnoreCase("Android")) {
			return new Android();
		}
		else if(str.equalsIgnoreCase("IOS")) {
			return new IOS();
		}
		return new Window();
	}
}

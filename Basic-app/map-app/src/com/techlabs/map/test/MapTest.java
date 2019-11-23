package com.techlabs.map.test;

import java.util.HashMap;
import java.util.Map;

import com.techlabs.map.MapClass;

public class MapTest {

	public static void main(String[] args) {
		MapClass maptest = new MapClass("1","Book");
		Map<String, String> maplst = maptest.allData();
		maplst.forEach((key,value) ->{
			System.out.println("Key: "+key+" value: "+value);
		});
	}

}

package com.techlabs.map.test;

import java.util.HashMap;

import com.techlabs.map.Map;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		map.addValue(11);
		map.addValue(12);
		map.addValue(13);
		map.updateValue(2, 100);
		map.removeData(1);
		hashmap = map.getAllData();
		
		System.out.println(hashmap);
	}

}

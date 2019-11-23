package com.techlabs.compare;

import java.util.Comparator;

import com.techlabs.line.item.LineItem;

public class CompareByName implements Comparator<LineItem>{

	@Override
	public int compare(LineItem o1, LineItem o2) {
		return o1.getProductname().compareTo(o2.getProductname());
	}
	
}

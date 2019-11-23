package com.techlabs.compare;

import java.util.Comparator;

import com.techlabs.line.item.LineItem;

public class CompareByCost implements Comparator<LineItem>{

	@Override
	public int compare(LineItem o1, LineItem o2) {
		if(o1.getCost() > o2.getCost()) {
			return -1;
		}
		else if(o1.getCost() < o2.getCost()) {
			return 1;
		}
		return 0;
	}
	
}

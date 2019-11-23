package com.techlabs.compare;

import java.util.Comparator;

import com.techlabs.line.item.LineItem;

public class CompareById implements Comparator<LineItem>{
	
	@Override
	public int compare(LineItem o1, LineItem o2) {
		if(o1.getId() > o2.getId()) {
			return 1;
		}
		else if(o1.getId() < o2.getId()) {
			return -1;
		}
		return 0;
	}
}

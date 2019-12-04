package com.techlabs.DomTest;

import com.techlabs.control.Control;
import com.techlabs.controlgroup.ControlGroup;

public class DomTest {
	public static void main(String[] args) {
		ControlGroup div = new ControlGroup("div");
		ControlGroup p = new ControlGroup("p");
		Control span = new Control("span","","UserName");
		Control inputusername = new Control("input","type=\"text\"","");
		ControlGroup p1 = new ControlGroup("p");
		Control span1 = new Control("span","","Password");
		Control password = new Control("input","type=\"password\"","");
		ControlGroup p2 = new ControlGroup("p");
		Control submit = new Control("input","type=\"submit\" value=\"login\"","");
		p.addControl(span);
		p.addControl(inputusername);
		p1.addControl(span1);
		p1.addControl(password);
		p2.addControl(submit);
		div.addControl(p);
		div.addControl(p1);
		div.addControl(p2);
		System.out.println(div.build());
	}
}

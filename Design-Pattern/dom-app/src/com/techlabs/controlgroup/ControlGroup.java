package com.techlabs.controlgroup;

import java.util.ArrayList;
import com.techlabs.IDom.IDomBuilder;

public class ControlGroup implements IDomBuilder{
	private ArrayList<IDomBuilder> controls = new ArrayList<>();
	private String tagname;
		
	public ControlGroup(String tagname) {
		this.tagname = tagname;
	}
	
	public void addControl(IDomBuilder control) {
		this.controls.add(control);
	}

	@Override
	public String build() {
		StringBuilder str = new StringBuilder("");
		str.append("<");
		str.append(this.tagname);
		str.append(">\n");
		for(IDomBuilder control : this.controls) {
			str.append(control.build());
		}
		str.append("</");
		str.append(this.tagname);
		str.append(">");
		str.append("\n");
		return str.toString();
	}

}

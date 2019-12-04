package com.techlabs.control;

import com.techlabs.IDom.IDomBuilder;

public class Control implements IDomBuilder{
	private String tagname;
	private String atrributes;
	private String innerHtml;
	
	public Control(String tagname, String atrributes, String innerHtml) {
		super();
		this.tagname = tagname;
		this.atrributes = atrributes;
		this.innerHtml = innerHtml;
	}

	@Override
	public String build() {
		StringBuilder str = new StringBuilder("");
		str.append("<");
		str.append(this.tagname);
		str.append(" "+this.atrributes);
		str.append(">");
		str.append(this.innerHtml);
		str.append("</");
		str.append(this.tagname);
		str.append(">");
		str.append("\n");
		return str.toString();
	}

}

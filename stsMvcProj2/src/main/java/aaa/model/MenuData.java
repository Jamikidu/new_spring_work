package aaa.model;

import lombok.Data;

@Data
public class MenuData {

	String url, txt;

	public MenuData(String url, String txt) {
		super();
		this.url = url;
		this.txt = txt;
	}
	
	
}

package aaa.model;

import lombok.Data;

@Data
public class Battery {

	String name;
	int size;
	
	public Battery(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}
	
	
}

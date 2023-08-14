package scan_coffee;

import org.springframework.stereotype.Component;

@Component
public class Water {
	String name = "아리수";
	int liter = 250;

	public Water() {
		// TODO Auto-generated constructor stub
	}

	public Water(String name, int liter) {
		super();
		this.name = name;
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "Water [name=" + name + ", liter=" + liter + "]";
	}
	
	
}

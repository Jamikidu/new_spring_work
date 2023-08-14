package scan_coffee;

import org.springframework.stereotype.Component;

@Component
public class Milk {
	String name = "경기우유";
	int liter = 250;

	public Milk() {
		// TODO Auto-generated constructor stub
	}

	public Milk(String name, int liter) {
		super();
		this.name = name;
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "Water [name=" + name + ", liter=" + liter + "]";
	}
	
	
}

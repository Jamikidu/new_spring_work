package scan_coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import anno_p.com.Bonche;
import anno_p.com.sub1.Mouse;
import jakarta.annotation.Resource;

@Component
public class Americano2 {
	
	//@Resource(name = "water")
	Water water;
	//@Resource(name = "coffeeBeans")
	CoffeeBeans coffeeBeans;
	int price;
	
	public Americano2(Water water, CoffeeBeans coffeeBeans) {
		super();
		this.water = water;
		this.coffeeBeans = coffeeBeans;
	}

	public void setWater(Water water) {
		this.water = water;
	}

	public void setCoffeeBeans(CoffeeBeans coffeeBeans) {
		this.coffeeBeans = coffeeBeans;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Americano [water=" + water + ", coffeeBeans=" + coffeeBeans + ", price=" + price + "]";
	}
	
	
}

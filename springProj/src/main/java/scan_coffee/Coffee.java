package scan_coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import anno_p.com.Bonche;
import anno_p.com.sub1.Mouse;
import jakarta.annotation.Resource;

@Component
public class Coffee {
	
	String name;
	//@Resource(name = "water")
	Water water;
	//@Resource(name = "coffeeBeans")
	CoffeeBeans coffeeBeans;
	int price;
	Milk milk;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	
	public Coffee(String name, Water water, CoffeeBeans coffeeBeans, int price) {
		super();
		this.name = name;
		this.water = water;
		this.coffeeBeans = coffeeBeans;
		this.price = price;
	}

	public Coffee(String name, Water water, CoffeeBeans coffeeBeans, Milk milk, int price) {
		super();
		this.name = name;
		this.water = water;
		this.coffeeBeans = coffeeBeans;
		this.milk = milk;
		this.price = price;
	}


	public void setName(String name) {
		this.name = name;
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

	public void setMilk(Milk milk) {
		this.milk = milk;
	}

	@Override
	public String toString() {
		return "Coffee [name=" + name + ", water=" + water + ", coffeeBeans=" + coffeeBeans + ", price=" + price
				+ ", milk=" + milk + "]";
	}


	
}

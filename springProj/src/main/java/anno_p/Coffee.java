package anno_p;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Coffee {

	String name;
	int price;
	
	@Autowired
	@Qualifier("bean3")
	Beans beans;
	
	@Autowired(required = false)
	@Qualifier("")
	List<Ingredients> ingres;
	
	@Autowired(required = true)
	public void setName(String name) {
		this.name = name;
	}
	@Autowired(required = true)
	public void setPrice(int price) {
		this.price = price;
	}
	public void setIngres(List<Ingredients> ingres) {
		this.ingres = ingres;
	}
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", beans=" + beans + ", ingres=" + ingres + "]";
	}
	
	
}

class Beans{
	String region, name;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Beans [name=" + name + ", region=" + region + "]";
	}
	
}

class Ingredients{
	String type, name;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ingredients [name=" + name + ", type=" + type + "]";
	}
	
}
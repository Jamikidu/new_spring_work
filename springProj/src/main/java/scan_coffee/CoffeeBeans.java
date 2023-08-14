package scan_coffee;

import org.springframework.stereotype.Component;

@Component
public class CoffeeBeans {
	String name = "유기농콜롬비아",kind = "라틴아메리카산";
	
	public CoffeeBeans() {
		// TODO Auto-generated constructor stub
	}
	
	public CoffeeBeans(String name, String kind) {
		super();
		this.name = name;
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "CoffeeBeans [name=" + name + ", kind=" + kind + "]";
	}
	
}

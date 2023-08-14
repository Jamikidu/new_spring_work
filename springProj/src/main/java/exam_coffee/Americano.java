package exam_coffee;

import org.springframework.stereotype.Component;

@Component
public class Americano {
	String beans = "아프리카산";
	String water = "아리수";
	int price = 2000;
	
	@Override
	public String toString() {
		return "Americano [beans=" + beans + ", water=" + water + ", price=" + price + "]";
	}
	
}

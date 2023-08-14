package exam_coffee;

import org.springframework.stereotype.Component;

@Component
public class CaramelMacchiato extends Americano{
	
	String beans = "아프리카산+2강";
	String water = "에비앙";
	String caramel = "포모나산";
	int price = 4200;
	
	@Override
	public String toString() {
		return "CaramelMacchiato [beans=" + beans + ", water=" + water + ", caramel=" + caramel + ", price=" + price
				+ "]";
	}
	
}

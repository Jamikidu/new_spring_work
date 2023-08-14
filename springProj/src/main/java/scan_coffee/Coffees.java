package scan_coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import anno_p.com.sub1.Mouse;
import jakarta.annotation.Resource;

@Configuration
public class Coffees {

	@Bean
	CoffeeBeans cbeans2() {
		return new CoffeeBeans("인도네시아만델링", "아시아산");
	}

	@Bean
	Water water2() {
		return new Water("기본생수", 255);
	}
	
	@Bean
	Coffee ame2(String name, Water water2, CoffeeBeans cbeans2, int price) {
		return new Coffee("아메리카노2", water2, cbeans2, 2300);
	}
	
	@Bean
	Coffee latte1(String name, Water water, CoffeeBeans cbeans2,Milk milk, int price) {
		return new Coffee("라떼1",water, cbeans2, milk, 2900);
	}

}

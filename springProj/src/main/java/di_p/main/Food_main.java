package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.FoodShop;

public class Food_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/food.xml","di_xml/foodstore.xml");
		
		FoodShop fs = context.getBean("fs",FoodShop.class);
				
		System.out.println("식단표호출\n" + fs.order_food());
		System.out.println(fs.order_bf());
		System.out.println(fs.order_lunch());
		System.out.println(fs.order_dinner());
		System.out.println(fs.order_midnight());
		
		
	}

}

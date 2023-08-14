package scan_coffee;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeScan_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/coffee_scan.xml");
		
		//System.out.println("americano:"+context.getBean("americano"));
		System.out.println(context.getBean("coffeeBeans"));
		System.out.println(context.getBean("cbeans2"));
		System.out.println(context.getBean("water"));
		System.out.println(context.getBean("water2"));
		System.out.println(context.getBean("coffee"));
		System.out.println(context.getBean("am2"));
		//System.out.println(context.getBean("latte1"));
	}

}

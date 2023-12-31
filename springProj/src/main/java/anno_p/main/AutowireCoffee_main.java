package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireCoffee_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/autowire_coffee.xml");

		System.out.println(context.getBean("cof1"));
		System.out.println(context.getBean("cof2"));
		System.out.println(context.getBean("cof3"));
		
		context.close();
	}

}

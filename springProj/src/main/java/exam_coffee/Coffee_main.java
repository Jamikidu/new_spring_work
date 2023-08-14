package exam_coffee;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Coffee_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/coffee_exam.xml");
		
		System.out.println("americano: "+context.getBean("americano"));
		System.out.println("cafeLatte: "+context.getBean("cafeLatte"));
		System.out.println("caramelMacchiato: "+context.getBean("caramelMacchiato"));
		System.out.println("coffee: "+context.getBean("coffee"));
	}

}

package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmartPhone_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/smartphone.xml");

		System.out.println("phone1 : "+ context.getBean("phone1"));
		System.out.println("phone2 : "+ context.getBean("phone2"));
		System.out.println("phone3 : "+ context.getBean("phone3"));
	}

}

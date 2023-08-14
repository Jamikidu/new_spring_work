package anno_p.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/bean.xml");

		System.out.println(context.getBean("hp920"));
		System.out.println(context.getBean("gm1"));
		//System.out.println(context.getBean("gm2")); 에러남
		System.out.println(context.getBean("nb"));
		System.out.println(context.getBean("ws1"));
		System.out.println(context.getBean("ws2"));
		
		context.close();


		

	}

}

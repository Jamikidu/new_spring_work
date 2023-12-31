package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanStudent_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/beanstudent.xml");
		/* 내가 한 방식
		System.out.println(context.getBean("st_red1"));
		System.out.println(context.getBean("st_red2"));
		System.out.println(context.getBean("st_red3"));
		System.out.println(context.getBean("st_blue1"));
		System.out.println(context.getBean("st_blue2"));
		System.out.println(context.getBean("st_blue3"));
		System.out.println(context.getBean("st_yellow1"));
		System.out.println(context.getBean("st_yellow2"));
		System.out.println(context.getBean("st_yellow3"));
		*/
		
		//String [] beans = context.getBeanDefinitionNames(); bean들 이름의 집합
		
		//System.out.println(Arrays.toString(beans));
		
		for (String bName :context.getBeanDefinitionNames()) {
			System.out.println(context.getBean(bName));
		}
		
		context.close();
	}

}

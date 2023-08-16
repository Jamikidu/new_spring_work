package anno_p.main;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anno_p.AnnoConfig;

public class Config_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AnnoConfig.class);

		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println(context.getBean("mtb"));
		System.out.println(context.getBean("pb"));
		System.out.println(context.getBean("nb"));
		System.out.println(context.getBean("rc1"));
		

	}

}

package anno_p.main;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anno_cloth.AnnoConfig_cloth;
import anno_cloth.ClothsSet;
import anno_p.AnnoConfig;

public class Cloth_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AnnoConfig_cloth.class);

		//System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		
		
		System.out.println(context.getBean("ge1"));
		System.out.println(context.getBean("ge3"));
		System.out.println(context.getBean("clo1"));
		System.out.println(context.getBean("clo3"));
		System.out.println(context.getBean("sh2"));
		System.out.println(context.getBean("sh3"));
		System.out.println("\n=================================================\n");
		System.out.println(context.getBean("set1"));
		System.out.println(context.getBean("set2"));
		System.out.println(context.getBean("set3"));
		
	}

}

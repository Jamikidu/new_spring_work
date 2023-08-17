package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;

public class AnnoMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/anno.xml");
		
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		System.out.println("jsk.dog1:"+jsk.dog1(12,"아기상어"));
		System.out.println("---------------");
		
		jsk.nums(2);
		System.out.println("---------------");
		jsk.nums(0);
		System.out.println("---------------");
	}

}

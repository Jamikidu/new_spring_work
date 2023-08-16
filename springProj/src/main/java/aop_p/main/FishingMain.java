package aop_p.main;

import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.Fishing;
import aop_p.webToon.JoSuk;

public class FishingMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/fishing.xml");
		Random ran = new Random();
		int ran1 = ran.nextInt(10,30); // 랜덤으로!
		
		Fishing fis = context.getBean("fishing",Fishing.class);
		
		System.out.println(fis.fish("고급갯지렁이", 28));
		System.out.println("====================================");
		System.out.println(fis.fish("싸구려떡밥", 19));
		System.out.println("====================================");
		System.out.println(fis.fish("일반미끼", ran1));
		System.out.println("====================================");
		System.out.println(fis.fish());
		
		
		
	}

}

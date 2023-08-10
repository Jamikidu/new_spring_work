package teacher.di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.Camera;
import di_p.HandPhone;
import di_p.bicycle.Bicycle;
import di_p.bicycle.InterBiCycle;

public class BiCycle_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/bicycle.xml");

		
		/* 출력1 */
		for (String str : "bc1,bc2,bc3".split(",")) {
			Bicycle bc = context.getBean(str,Bicycle.class);
			System.out.println(bc);
		}
		
		
	}

}

package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.Class1;
import obar.BarTable;
import obar.Obar;
import teacher.di_p.Exam;
import teacher.di_p.Stud;

public class dumy_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/cloth.xml");

		System.out.println(context.getBean("ge3"));
		
		

		context.close();
	}

}

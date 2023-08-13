package obar.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.Class1;
import obar.BarTable;
import obar.Obar;
import teacher.di_p.Exam;
import teacher.di_p.Stud;

public class Obar_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/obar.xml");

		System.out.println(context.getBean("bar1"));
		
		for (BarTable bar: context.getBean("bar1", Obar.class).getTable()) {
			System.out.println(bar+"\n");
		}
		

		context.close();
	}

}

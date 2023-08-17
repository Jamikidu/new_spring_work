package aop_p.main;

import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.classroom.Stud;
import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;
import aop_p.webToon.KangSan;

public class AwbStudMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/myclass.xml");
		
		Random rd = new Random();

		Stud std = context.getBean("stud",Stud.class);
		std.subj2room(10, 20);
		std.subj2room(14, 25);
		std.subj2room(30, 50);
		System.out.println("====================================");
		std.subj3room(5, 11, 35);
		std.subj3room(45, 76, 28);
		std.subj3room(35, 13, 47);
		std.subj3room(23, 55, 61);
		System.out.println("====================================");
		// 과목4개 반 학생 5개면 만들기
		for(int i=0;i<5;i++) {
			int num1 = rd.nextInt(1,99);
			int num2 = rd.nextInt(1,99);
			int num3 = rd.nextInt(1,99);
			int num4 = rd.nextInt(1,99);
			std.subj4room(num1, num2, num3, num4);
		}

	
	}

}

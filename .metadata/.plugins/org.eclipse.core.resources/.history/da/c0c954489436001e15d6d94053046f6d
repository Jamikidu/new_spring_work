package di_p.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.Camera;
import di_p.Exam;
import di_p.HambugerSet;
import di_p.HandPhone;
import di_p.Stud;

public class Collection_ExamMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("di_xml/coll_exam.xml");

		
		for (Stud st: context.getBean("exam", Exam.class).getStuds()) {
			System.out.println(st);
		}
		
		System.out.println("================================================");
		
		for (Stud st: context.getBean("exam", Exam.class).getSet()) {
			System.out.println(st);
		}
		
		
	}

}

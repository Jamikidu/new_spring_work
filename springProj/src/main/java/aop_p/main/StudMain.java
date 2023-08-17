package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.model.GreenStud;
import aop_p.model.RedStud;
import aop_p.model.StudRes;
import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;
import aop_p.webToon.KangSan;

public class StudMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/stud.xml");
		
		//JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		//GreenStud gs = new GreenStud();
		
		StudRes studRes = context.getBean("studRes", StudRes.class);
		GreenStud gs = context.getBean("greenStud", GreenStud.class);
		//RedStud rs = context.getBean("redStud", RedStud.class);
		gs.setJum(98,37);
		gs.setJum(12,78,77,97);
		gs.setJum(38,97);
		gs.setJum(58,34,56,87);
		gs.setJum(78,77);
		gs.setJum(98,37,88);
		gs.setJum(58,87);
		gs.setJum(38,97,72);
		
		
		//rs.setJum(98,37);
		System.out.println("---------------");
		studRes.ppp();
	/*
	 학생성적을 계산하세요
	 과목 2 : 뭐라고하는반
	 과목 3 : 일반
	 과목 4 : 예체능
	 
	aop를 이용하여 학생분류별 인원수와 평균합계, 평균의 평균을 구하세요
	 * */
		
	}

}

package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;
import aop_p.webToon.KangSan;

public class AwbMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/awb.xml");
		
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		KangBada kbd = context.getBean("kbd",KangBada.class);
		KangSan kangSan = context.getBean("kangSan",KangSan.class);
		System.out.println("jsk.dog1:"+jsk.dog1(12,"아기상어"));
		System.out.println("---------------");
		System.out.println("jsk.wife:"+jsk.wife());
		System.out.println("---------------");
		System.out.println("jsk.papa:"+jsk.papa(44));
		System.out.println("---------------");
		kbd.dogdo();
		System.out.println("---------------");
		kangSan.yunFish();
		System.out.println("---------------");
		kangSan.ra9yo();
		System.out.println("---------------");
		
		/*
		 * 학생성적을 계산하세요 
		 * 과목 2개 : 뭐라고하는반 
		 * 과목 3개 : 일반 
		 * 과목 4개 : 예체능
		 * 
		 * aop를 이용하여 각 학생분류별 인원수와 평균합계, 평균의 평균(반평균?)을 구하세요
		 */
	
	}

}

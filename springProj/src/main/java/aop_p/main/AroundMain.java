package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;

public class AroundMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/around.xml");
		
		JoSuk jsk = context.getBean("joSuk",JoSuk.class);
		KangBada kbd = context.getBean("kbd",KangBada.class);
		System.out.println("jsk.dog1:"+jsk.dog1(12,"아기상어"));
		System.out.println("---------------");
		System.out.println("jsk.wife:"+jsk.wife());
		System.out.println("---------------");
		System.out.println("jsk.papa:"+jsk.papa(33));
		System.out.println("==============================");
		System.out.println("kbd.fishing(지렁이):"+kbd.fishing("지렁이"));
		System.out.println("---------------");
		System.out.println("kbd.fishing():"+kbd.fishing());
		System.out.println("---------------");
		System.out.println("kbd.fishing(새우):"+kbd.fishing("새우"));
		System.out.println("---------------");
		System.out.println("kbd.fishing(떡밥):"+kbd.fishing("떡밥"));
		System.out.println("---------------");
		System.out.println("kbd.fishing(오징어):"+kbd.fishing("오징어"));
		System.out.println("---------------");
		
		/*
		 낚시를 구현하세요
		 
		 미끼를 넣지 않고 낚시할 경우 : 미끼를 넣으세요 메세지 호출 후 자동 종료
		 
		 낚시한 물고기가 20cm 이하인 경우 : 풀어주자 메세지 호출 및 리턴 물고기 null 로 변경
		 
		 * */
		
	}

}

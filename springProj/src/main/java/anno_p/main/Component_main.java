package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Component_main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("anno_xml/component.xml");
		
		System.out.println("mouse: "+context.getBean("mouse")); //xml에서 mouse를 빈으로 등록하지 않았음에도 실행됨
		//System.out.println(context.getBean("Mouse")); //대문자로하면 못 읽어옴
		System.out.println("noteBook:"+context.getBean("noteBook"));
		System.out.println("bbcc:"+context.getBean("bbcc"));
		System.out.println("DESKTop:"+context.getBean("DESKTop")); //대문자가 연속으로 붙어서 클래스네이밍이 됐을경우는 이름 그대로 넣어줘야함
		
		context.close();
	}

}

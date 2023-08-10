package di_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di_p.Camera;
import di_p.HandPhone;
import di_p.bicycle.Bicycle;

public class DI_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HandPhone hp1 = new HandPhone();
		Camera cam1 = new Camera("수중카메라",800);
		
		//cam1.setName("전방카메라");
		//cam1.setPixel(1000);
		
		hp1.setName("은하수23");
		hp1.setCam(cam1);
		
		
		System.out.println(hp1);
		
		System.out.println("------------------------------------------");
		AbstractApplicationContext context = //context 생성했을때 기본생성자가 생성
				new ClassPathXmlApplicationContext("di_xml/first.xml");
		
		System.out.println("------------------------------------------");
		HandPhone hp2 = (HandPhone)context.getBean("hp2");
		System.out.println(hp2);
		
		System.out.println(context.getBean("cam3"));
		System.out.println(context.getBean("cam5"));
	}

}

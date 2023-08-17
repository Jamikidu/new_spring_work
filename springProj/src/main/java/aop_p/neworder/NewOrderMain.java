package aop_p.neworder;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;

public class NewOrderMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/neworder.xml");
		
		Orders ord = context.getBean("orders",Orders.class);
		NewOrder nod = context.getBean("newOrder",NewOrder.class);
		System.out.println("-----------------------------------------");
		nod.order("김치찌개", "찌개", 7500);
		nod.order("돼지김치찌개", "찌개", 10000);
		nod.order("된장찌개", "찌개", 8000);
		nod.order("소고기된장찌개", "찌개", 11000);
		nod.order("소고기덮밥단품", "덮밥", 8800);
		nod.order("소고기덮밥세트", "덮밥", 11800);
		nod.order("돼지고기덮밥단품", "덮밥", 7200);
		nod.order("돼지고기덮밥세트", "덮밥", 10500);
		System.out.println("-----------------------------------------");
		ord.show찌개();
		ord.show덮밥();
	}

}

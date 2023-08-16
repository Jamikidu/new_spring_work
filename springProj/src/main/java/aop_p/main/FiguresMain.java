package aop_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop_p.webToon.Circle;
import aop_p.webToon.Figures;
import aop_p.webToon.JoSuk;
import aop_p.webToon.KangBada;
import aop_p.webToon.KangSan;

public class FiguresMain {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("aop_xml/figures.xml");
		
		Figures fig = context.getBean("figures",Figures.class);
		fig.Circle(4);
		fig.Rectangle(4,3);
		fig.RightTriangle(4,3,5);
//		
//		
		
//		Circle fig1 = context.getBean("circle",Circle.class);
//		fig1.setR(4);
//		System.out.println(fig1.getCirArea()+"cm2");
//		System.out.println(fig1.getCirRound()+"cm");
		

	}

}

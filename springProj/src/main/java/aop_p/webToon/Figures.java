package aop_p.webToon;

import org.springframework.stereotype.Component;

@Component
public class Figures {
	
	
	public void Circle(float r) {
//		float PI = (float)Math.floor(Math.PI*100)/100;
//		float cirArea = r*r*PI;
//		float cirRound = 2*PI*r;
//		
//		//System.out.println("구의 반지름은: "+r+"cm2, 넓이는 "+cirArea+"cm2, 둘레는 "+cirRound+"cm");
	}
	
	public void Rectangle(int recw, int rech) {
		
//		int recArea = recw * rech;
//		int recRound = 2*(recw+rech);
//		
//		//System.out.println("직사각형의 넓이는 "+recArea+"cm2, 둘레는 "+recRound+"cm");
	}
	
	public void RightTriangle(int rigw,int righ,int hypotenuse) {
//		int rigArea = (rigw*righ)/2;
//		int rigRound = rigw+righ+hypotenuse;
//		
//		System.out.println("직각삼각형의 넓이는 "+rigArea+"cm2, 둘레는 "+rigRound+"cm");
	}
}

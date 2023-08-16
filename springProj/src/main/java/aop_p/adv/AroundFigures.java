package aop_p.adv;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AroundFigures {

	void culcCircle(JoinPoint joinPoint) {
		//Object res = null;

		System.out.println(" >> culcCircle 진입: "+joinPoint.toString());
		System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
		
		
		try {
			float PI = (float)Math.floor(Math.PI*100)/100;
			
			//res = joinPoint.proceed();
			float r = (float)joinPoint.getArgs()[0];
			float cirArea = r*r*PI;
			float cirRound = 2*PI*r;
			String answer="구의 반지름은: "+r+"cm2, 넓이는 "+cirArea+"cm2, 둘레는 "+cirRound+"cm";
			System.out.println(answer);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" >> culcCircle 완료");
	}
	
	void culcRectangle(ProceedingJoinPoint joinPoint) {
		
		System.out.println(" >> culcRectangle 진입: "+joinPoint.toString());
		System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
		
		
		try {
			
			//Object res = joinPoint.proceed();
			int recw = (int)joinPoint.getArgs()[0];
			int rech = (int)joinPoint.getArgs()[1];
			int recArea = recw * rech;
			int recRound = 2*(recw+rech);
			String answer="직사각형의 넓이는 "+recArea+"cm2, 둘레는 "+recRound+"cm";
			System.out.println(answer);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" >> culcRectangle 완료");
	}
	
	void culcRightTriangle(ProceedingJoinPoint joinPoint) {
		
		System.out.println(" >> culcRightTriangle 진입: "+joinPoint.toString());
		System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
		
		
		try {
			//Object res = joinPoint.proceed();
			int rigw = (int)joinPoint.getArgs()[0];
			int righ = (int)joinPoint.getArgs()[1];
			int hypotenuse = (int)joinPoint.getArgs()[2];
			int rigArea = (rigw*righ)/2;
			int rigRound = rigw+righ+hypotenuse;
			String answer="직각삼각형의 넓이는 "+rigArea+"cm2, 둘레는 "+rigRound+"cm";
			System.out.println(answer);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" >> culcRightTriangle 완료");
	}
}

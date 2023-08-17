package aop_p.adv;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import aop_p.model.GreenStud;
import aop_p.model.StudRes;
import jakarta.annotation.Resource;

@Component
public class StudAdvice {
	
	@Resource
	StudRes sRes;

	Object employee(ProceedingJoinPoint joinPoint, int qq, int ww) {
		Object res = null;
		
		try {
			joinPoint.proceed();
			
			GreenStud gs = (GreenStud)joinPoint.getTarget();
			gs.kind = "직장인";
				
			sRes.add(gs);
			//System.out.println("sRes:"+sRes);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	Object general(ProceedingJoinPoint joinPoint, int qq, int ww, int tt) {
		Object res = null;
		
		try {
			joinPoint.proceed();
			
			GreenStud gs = (GreenStud)joinPoint.getTarget();
			gs.kind = "일반";
			sRes.add(gs);
			//System.out.println("sRes:"+sRes);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	Object spec(ProceedingJoinPoint joinPoint, int qq, int ww, int tt, int aa) {
		Object res = null;
		
		try {
			joinPoint.proceed();
			
			GreenStud gs = (GreenStud)joinPoint.getTarget();
			gs.kind = "예체능";	
			sRes.add(gs);
			//System.out.println("sRes:"+sRes);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}

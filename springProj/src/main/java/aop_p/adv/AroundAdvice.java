package aop_p.adv;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

	Object arTest(ProceedingJoinPoint joinPoint) {
		Object res = null;
		
		System.out.println(" >> arTest 진입:"+joinPoint.toString());
		System.out.println(" >> ShortString:"+joinPoint.toShortString());
		System.out.println(" >> getSignature:"+joinPoint.getSignature());
		System.out.println(" >> Signature().getName():"+joinPoint.getSignature().getName());
		System.out.println(" >> Signature().toShortString():"+joinPoint.getSignature().toShortString());
		System.out.println(" >> getTarget():"+joinPoint.getTarget());
		System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
		System.out.println(" >> getThis():"+joinPoint.getThis());
		
		try {
			
			if(joinPoint.getArgs().length>=2) {
				joinPoint.getArgs()[1] = "엄마상어";
				System.out.println(" >> 변경한 getArgs():"+Arrays.toString(joinPoint.getArgs()));
			}
			
			res = joinPoint.proceed();  //joinPoint(조건)이 맞으면 실행시킴!
			
			if(res.equals("애봉")) {
				res = "조준";
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" >> arTest 완료");
		return res;
	}
}

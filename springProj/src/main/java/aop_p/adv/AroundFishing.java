package aop_p.adv;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundFishing {

	Object arFish(ProceedingJoinPoint joinPoint) {
		Object res = null;
		
//		System.out.println(" >> arFish 진입: "+joinPoint.toString());
//		System.out.println(" >> ShortString:"+joinPoint.toShortString());
//		System.out.println(" >> getSignature:"+joinPoint.getSignature());
//		System.out.println(" >> Signature().getName():"+joinPoint.getSignature().getName());
//		System.out.println(" >> Signature().toShortString():"+joinPoint.getSignature().toShortString());
//		System.out.println(" >> getTarget():"+joinPoint.getTarget());
//		System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
//		System.out.println(" >> getThis():"+joinPoint.getThis());
		
		try {
			
			if(joinPoint.getArgs().length==0) {
				System.out.println("미끼가 없네요... (종료)");
				System.exit(0);
			}
			else {
				res = joinPoint.proceed();  //joinPoint(조건)이 맞으면 실행시킴!
				
				if((int)joinPoint.getArgs()[1]<=20) {
					res = "이런이런 물고기가 너무 작아서 놓아줍니다 "+null;
				}
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" >> arFish 완료");
		return res;
	}
}

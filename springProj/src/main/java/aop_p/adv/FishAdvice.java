package aop_p.adv;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

import aop_p.webToon.KangFish;

public class FishAdvice {

	Object fishTest(ProceedingJoinPoint joinPoint) {
		KangFish res = null;
		
		String [] stArr = (String [] )(joinPoint.getArgs())[0];
		
		
		
		
		
		try {
			
			if(stArr.length==0) {
				System.out.println("미끼를 넣으세요");
			}else {
			
				res = (KangFish)joinPoint.proceed();
				if(res.size<=20) {
					System.out.println("풀어주자:"+res);
					res = null;
				}
			}
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}

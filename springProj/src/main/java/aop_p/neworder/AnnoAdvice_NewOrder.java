package aop_p.neworder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


//@Component  가능하지만 용어의 편의상으로 Service로 주로 사용
@Service
@Aspect
public class AnnoAdvice_NewOrder {
	Map<String, Integer> 찌개 = new HashMap();
	Map<String, Integer> 덮밥 = new HashMap();
	@Around("execution(* aop_p.neworder..* (..))")
	Object divide(ProceedingJoinPoint joinPoint) {
		System.out.println(">>> divide:"+joinPoint.getSignature().toShortString());
		//System.out.println(" >> getArgs():"+Arrays.toString(joinPoint.getArgs()));
		Object res = null;
		try {
			joinPoint.proceed();
			if(joinPoint.getArgs()[1].equals("찌개")) {
				if((int)joinPoint.getArgs()[2]<10000) {
					찌개.put((String)joinPoint.getArgs()[0],(int)joinPoint.getArgs()[2]+3000);
					System.out.println("10000원 미만은 배달비 3000원 추가됩니다.");
				}else {
					찌개.put((String)joinPoint.getArgs()[0],(int)joinPoint.getArgs()[2]);
				}
				
			}
			if(joinPoint.getArgs()[1].equals("덮밥")) {
				if((int)joinPoint.getArgs()[2]<10000) {
					덮밥.put((String)joinPoint.getArgs()[0],(int)joinPoint.getArgs()[2]+3000);
					System.out.println("10000원 미만은 배달비 3000원 추가됩니다.");
				}else {
					덮밥.put((String)joinPoint.getArgs()[0],(int)joinPoint.getArgs()[2]);
				}
				
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(찌개);
		System.out.println("찌개종류 주문 수: "+찌개.size());
		System.out.println(덮밥);
		System.out.println("덮밥종류 주문 수: "+덮밥.size());
		return res;
		
	}
	
//	@Pointcut("execution(* aop_p.webToon..* (..))")
//	void pppiii() {}
//	
//	@After("pppiii()")
//	void afterrr(JoinPoint joinPoint) {
//		System.out.println(">>> afterrr:"+joinPoint.getSignature().toShortString());
//	}
//	
//	@AfterReturning(pointcut = "pppiii()", returning = "qq")
//	void returnnn(JoinPoint joinPoint, Object qq) {
//		System.out.println(">>> returnnn:"+joinPoint.getSignature().toShortString()+" =>"+qq);
//	}
//	
//	@AfterThrowing(pointcut = "pppiii()", throwing = "ee")
//	void errrr(JoinPoint joinPoint, Throwable ee) {
//		System.out.println(">>> errrr:"+joinPoint.getSignature().toShortString()+" =>"+ee.getMessage());
//	}
	
	/*
	 * 식당 주문을 구현하세요
	 * 
	 * 주문 종류에 따른 개수를 구하세요
	 * 종류
	 * 찌개, 덮밥
	 * 
	 * 가격이 10000 미만인 경우 배달비를 추가하세요
	 * 
	 * 종류와 배달비 계산은 aop, annotation 으로 처리
	*/
}

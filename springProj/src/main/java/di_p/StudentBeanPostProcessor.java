package di_p;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudentBeanPostProcessor implements BeanPostProcessor {

	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println("StudentMyBeanPostProcessor.AfterInit 실행:"+beanName+" => " + bean);
		
			System.out.println(bean+" 인스턴스 생성");
			Student2 st = (Student2)bean;
			float b_avg = st.getAvg();
			
			if(st.getName().startsWith("red")) {
				System.out.println(" red 포함 확인. 등급을 수,우,미,양,가 로 처리하겠습니다\n");
				String grade = "가가가가가가양미우수수".charAt((int)(b_avg/10.0))+"";
				st.setGrade(grade);
			}
			if(st.getName().startsWith("blue")) {
				System.out.println(" blue 포함 확인. 등급을 A,B,C,D,E 로 처리하겠습니다\n");
				//"가가가가가가양미우수수".charAt(avg/10)+"";  //평균을 10으로 나눴을때 나오는 몫에 해당하는 문자를 할당
				String grade = "FFFFFFDCBAA".charAt((int)(b_avg/10.0))+"";
				st.setGrade(grade);
			}
			if(st.getName().startsWith("yellow")) {
				System.out.println(" yellow 포함 확인. 등급을 1,2,3,4,5 로 처리하겠습니다\n");
				String grade = "55555543211".charAt((int)(b_avg/10.0))+"";
				st.setGrade(grade);
				/* 이런 원초적인 방법도 있음
				if(st.getAvg()>=90) {
					st.setGrade("1");
				}
				else if(st.getAvg()>=80) {
					st.setGrade("2");
				}
				else if(st.getAvg()>=70) {
					st.setGrade("3");
				}
				else if(st.getAvg()>=60) {
					st.setGrade("4");
				}
				else {
					st.setGrade("5");
				}
				*/
			}
		
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}

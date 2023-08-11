package di_p;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudBeanPostProcessor implements BeanPostProcessor {

	HashMap<String, char[]> map;
	public StudBeanPostProcessor() {
		map = new HashMap();
		map.put("red","가가가가가가양미우수수".toCharArray());
		map.put("blue","FFFFFFDCBAA".toCharArray());
		map.put("Yello","11111123455".toCharArray());
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		
		for (Map.Entry<String, char[]> me : map.entrySet()) {
			if(beanName.startsWith( me.getKey())) {
				//System.out.println(beanName+":"+Arrays.toString(me.getValue()));
				Stud st = (Stud)bean;
				st.setGrade(""+me.getValue()[st.avg/10]);
			}
		}
		
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
}

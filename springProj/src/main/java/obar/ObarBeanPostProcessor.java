package obar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ObarBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// System.out.println("StudentMyBeanPostProcessor.AfterInit 실행:"+beanName+" ===>
		// " + bean);
		// System.out.println(bean+" 인스턴스 생성");

		if (bean.getClass().getName().equals("obar.BarTable")) {
			BarTable tab = (BarTable) bean;
			int alctot = 0;
			int cuitot = 0;

			for (int i = 0; i < tab.getAlc().size(); i++) {
				alctot += tab.getAlc().get(i).atot;
			}

			for (int i = 0; i < tab.getCui().size(); i++) {
				cuitot += tab.getCui().get(i).ctot;
			}

			tab.setTotalprice(alctot + cuitot);
			System.out.println(tab.name+" 계산완료!");
		}

		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}

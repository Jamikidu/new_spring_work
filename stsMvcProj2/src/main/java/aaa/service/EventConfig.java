package aaa.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.Resource;

@Configuration
public class EventConfig implements WebMvcConfigurer {

	@Resource
	EventInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		registry.addInterceptor(interceptor)
		.addPathPatterns("/event/gogo")
		.addPathPatterns("/admin/**")
		.excludePathPatterns("/admin/ccc");
	}
}

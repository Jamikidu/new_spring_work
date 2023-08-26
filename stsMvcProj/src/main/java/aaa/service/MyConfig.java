package aaa.service;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aaa.model.Battery;
import aaa.model.MenuData;
import aaa.model.SeasonMain;

@Configuration
public class MyConfig {

	@Bean
	Battery bat1() {
		return new Battery("로케트밧데리", 500);
	}
	
	@Bean
	Battery bat2() {
		return new Battery("사랑의밧데리", 300);
	}
	
	@Bean
	SeasonMain summer() {
		//SeasonMain data = ;
		//data.getData().put("summer","sua.png,sub.png".split(","));
		
		
		return new SeasonMain("summer","sua.png","sub.png");
		//return data;
	}
	
}

package aaa.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class EventInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		System.out.println("preHandle 진입");
		
		Date chkDay = new Date(2023-1900, 7-1, 28);
		Date today = new Date();
		
		if(chkDay.before(today)) {
			response.sendRedirect("/event/faaail");
			return false;
		}
		
		
		return true;
	}
}

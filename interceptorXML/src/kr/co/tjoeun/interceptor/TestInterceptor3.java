package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor3 implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor3 - preHandle");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/*
	 Controller의 메소드 수행이 완료되고 
	 View 처리를 수행하기 전에 자동으로 호출되는 메소드
	 */
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor3 - postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/*
	 View 처리까지 완료되고 응답 결과(response)가 
	 client의 browser로 전달되기 전에 자동으로 호출되는 메소드
	 */
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor3 - afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}

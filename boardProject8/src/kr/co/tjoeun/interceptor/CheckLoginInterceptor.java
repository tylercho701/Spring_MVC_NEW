package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	/*
	java 방식에서 interceptor는 bean을 자동으로 주입 받지 못함 ( = Autowired가 작동하지 않음)
	생성자의 parameter에서 TopMenuService topMenuService 객체를 주입 받아
	멤버 변수로 선언한 TopMenuService topMenuService에 전달함
	
	XML 방식에서는 autowired와 resource+lazy annotation을 이용함
	 */
	
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//	로그아웃 한 상태라면
		if(loginUserBean.isUserLogin() == false) {
			
			//	ContextPath 를 얻어옴
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");
			
			//	preHandle의 return 값이 false이면, interceptor가 동작하지 않음
			return false;
		}
		
		//	로그인 된 상태라면
		return true;
	}
}
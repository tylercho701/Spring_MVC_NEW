package kr.co.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.BoardInfoBean;
import kr.co.tjoeun.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {
	
	/*
		interceptor에서는 bean을 자동으로 주입 받지 못함 ( = Autowired가 작동하지 않음)
		생성자의 parameter에서 TopMenuService topMenuService 객체를 주입 받아
		멤버 변수로 선언한 TopMenuService topMenuService에 전달함
	*/
	
	private TopMenuService topMenuService;
	
	//	public TopMenuInterceptor() {}		-->		ServletAppContext에서 topMenuService 참조 변수를 넣지 않으려면 기본 생성자 생성해야 함
	public TopMenuInterceptor(TopMenuService topMenuService) {
		this.topMenuService = topMenuService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}
	
}
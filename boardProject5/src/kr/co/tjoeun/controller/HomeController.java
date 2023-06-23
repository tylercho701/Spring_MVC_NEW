package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.tjoeun.bean.UserBean;

@Controller
public class HomeController {
	
	// annotation의 value로 호출되는 controller이기 때문에,
	// method name은 어떤것을 사용해도 관계없음
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		//	String path = request.getContextPath();
		//	System.out.println("home");
		
		//	System.out.println("loginUserBean : " + loginUserBean);
		
		return "redirect:/main";
		
		/*
		 /WEB-INF/views/index.jsp 에서 
		 /WEB-INF/views/		<	이 부분을 prefix (접두사)로 설정하고 
		 .jsp					<	이 부분을 suffix (접미사)로 설정하면, 
		 
		   ㄴ index만 입력해도 해당 페이지로 접근함
		 */
	}
}
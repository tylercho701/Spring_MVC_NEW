package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// annotation의 value로 호출되는 controller이기 때문에,
	// method name은 어떤것을 사용해도 관계없음
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
		return "index";
		
		/*
		 /WEB-INF/views/index.jsp 에서 
		 /WEB-INF/views/		<	이 부분을 prefix (접두사)로 설정하고 
		 .jsp					<	이 부분을 suffix (접미사)로 설정하면, 
		 
		   ㄴ index만 입력해도 해당 페이지로 접근함
		 */
	}
	
	@RequestMapping(value="/spring", method=RequestMethod.GET)
	public String spring() {
		System.out.println("spring");
		return null;
	}
	
	@RequestMapping(value="/tjoeun", method=RequestMethod.GET)
	public String tjoeun() {
		System.out.println("tjoeun");
		return null;
	}
}
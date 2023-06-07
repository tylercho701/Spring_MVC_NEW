package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.DataBean1;
import kr.co.tjoeun.beans.DataBean2;
import kr.co.tjoeun.beans.DataBean3;

@Controller
public class TestController {
	
	@PostMapping("/test1")
	public String test1(@ModelAttribute DataBean1 bean1) {
		
		//	DataBean1 : 커맨드 객체
		//	커맨드 객체는 HttpServletRequest 객체에 자동으로 담겨서
		//	지정한 이름의 View(test1.jsp) 로 전달됨 -> EL로 화면에 출력함
		//	이때, HttpServletRequest 객체에 자동으로 저장되는 이름은 클래스의 이름으로 됨
		//												첫 글자가 소문자로 되어서 저장됨
		//												${requestScope.dataBean1.number1 }
		//	(@ModelAttribute DataBean1 bean1)	<--	Parameter로 선언된 객체(DataBean1)를
		//											HttpServletRequest 객체에 담아서
		//											
		
		System.out.printf("number1 : %s\n", bean1.getNumber1());
		System.out.printf("number2 : %s\n", bean1.getNumber2());
		
		
		
		
		return "test1";
	}
	
	//	HttpServletRequest 객체에 자동으로 저장되는 이름을 클래스 이름으로 안하고
	//	다른 이름으로 하고자 할 때는, '@ModelAttribute("bean2") DataBean2 bean2' 와 같이 작성한다.
	//	test2.jsp에서 'bean2'로 인식하게 됨
	@PostMapping("/test2")
	public String test2(@ModelAttribute("bean2") DataBean2 bean2) {
		
		System.out.printf("number3 : %s\n", bean2.getNumber3());
		System.out.printf("number4 : %s\n", bean2.getNumber4());
		
		
		
		
		return "test2";
	}
	
	
	//	@ModelAttribute 어노테이션 생략
	@PostMapping("/test3")
	public String test3(DataBean3 bean3) {
		
		System.out.printf("number3 : %s\n", bean3.getNumber5());
		System.out.printf("number4 : %s\n", bean3.getNumber6());
		
		return "test3";
	}
}
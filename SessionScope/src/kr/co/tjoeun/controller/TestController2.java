package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

@Controller
@SessionAttributes({"sessionBean1","sessionBean2"})
//	여러개의 객체를 넣고자 하면 '@SessionAttributes({"","",""}) 형식으로 설정 가능
public class TestController2 {
	
	//	@ModelAttribute를 활용해서 객체를 생성하고 반환하는 메소드를 작성해야 함
	//	return new TestBean1() 에서 반환하는 객체의 주소를
	//	@ModelAttribute("sessionBean1")에 지정한
	//	"sessionBean1" 라는 이름으로 session에서 저장함
	@ModelAttribute("sessionBean1")
	public TestBean1 sessionBean1() {
		
		return new TestBean1();
	}
	
	@ModelAttribute("sessionBean2")
	public TestBean2 sessionBean2() {
		
		return new TestBean2();
	}
	
	@GetMapping("test7")
	public String test7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		
		return "test7";
	}
	
	@GetMapping("result7")
	public String result7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		
		return "result7";
	}
	
	@GetMapping("test8")
	public String test8(@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		
		sessionBean2.setData3("화면구현2");
		sessionBean2.setData4("UI테스트2");
		
		return "test8";
	}
	
	@GetMapping("result8")
	public String result8(@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		
		return "result8";
	}
	
	@GetMapping("test9")
	public String test9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
						@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		
		
		sessionBean2.setData3("화면구현2");
		sessionBean2.setData4("UI테스트2");
		
		return "test9";
	}
	
	@GetMapping("result9")
	public String result9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
						  @ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		
		return "result9";
	}
}
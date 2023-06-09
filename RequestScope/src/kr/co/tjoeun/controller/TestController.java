package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {

	//HttpServletRequest 객체로 주입
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		
		//	setAttribute되면 object로 넘어감
		request.setAttribute("data1", data1);
		System.out.printf("data1 = %s\n", data1);
		
		//	return을 redirect로 전달하면 HttpServletRequest가 초기화 된 후 넘어가기 때문에
		//	data가 담기지 못함
		
		return "forward:/result1";
	}
	@GetMapping("result1")
	public String result(HttpServletRequest request) {
		
		//	object로 넘어오기 때문에 String으로 형변환 해야 함
		String data1 = (String)request.getAttribute("data1");
		
		System.out.printf("data1 = %s\n", data1);
		
		return "result1";
	}
	
	
	//	Model 객체로 주입
	@GetMapping("/test2")
	public String test2(Model model) {
		
		//	object로 넘김
		model.addAttribute("data2", "JavaWeb");
		
		return "forward:/result2";
	}
	@GetMapping("/result2")
	public String result2(HttpServletRequest request) {
		
		//	object로 넘어오기 때문에 String으로 형변환 해야 함
		//	model 객체로 넘겨도 받는건 HttpServletRequest로 받아야 함
		String data2 = (String)request.getAttribute("data2");
		System.out.println(data2);
		
		
		return "result2";
	}
	
	//	ModelAndView 객체로 주입
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		
		//	ModelAndView 객체를 사용해서 data를 메모리에 올리면
		//	requestScope 영역에서 HttpServletRequest 객체에 저장됨
		mv.addObject("data3", "스프링 프로젝트");
		mv.setViewName("forward:/result3");
		
		return mv;
	}
	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		
		//	object로 넘어오기 때문에 String으로 형변환 해야 함
		//	ModelAndView 객체로 넘겨도 받는건 HttpServletRequest로 받아야 함
		String data3 = (String)request.getAttribute("data3");
		System.out.println(data3);
		
		
		return "result3";
	}
	
	//	Bean 객체에 Model 객체로 주입
	@GetMapping("/testBean1")
	public String testBean1(Model model) {
		
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("스프링");
		bean1.setData2("웹개발");
		
		model.addAttribute("bean1", bean1);
		
		return "forward:/result4";
	}
	@GetMapping("result4")
	public String result4(HttpServletRequest request) {
		
		TestBean1 bean1 = (TestBean1)request.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result4";
	}
	
	
//	Bean 객체 Setter에 바로 주입
	@GetMapping("/testBean1_2")
	public String testBean1_2(@ModelAttribute("bean1") TestBean1 bean1) {
		
		bean1.setData1("자바개발자");
		bean1.setData2("파이썬개발자");
		
		//	return "result4_2";
		return "forward:/result5";
	}
	@GetMapping("/result5")
	public String result5(@ModelAttribute("bean1") TestBean1 bean1, HttpServletRequest request) {
		
		bean1 = (TestBean1) request.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		
		return "result5";
	}
}
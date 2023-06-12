package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		//	HttpSession 객체 생성하기
		HttpSession session = request.getSession();
		
		//	Session 영역에 data 저장하기
		session.setAttribute("data1", "스프링웹");
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		
		//	HttpSession 객체 생성하기
		HttpSession session = request.getSession();
		
		//	Session 영역에 data 가져오기
		String data1 = (String)session.getAttribute("data1");
		
		System.out.printf("data1 = %s\n", data1);
	
		return "result1";
	}
	
	@GetMapping("/test2") 
	public String test2_redirect(HttpSession session) {
	 
		//	HttpSession 객체 생성하기
		//	session = request.getSession();
	 
		//	Session 영역에 data 가져오기
		session.setAttribute("data1", "이클립스");
		
		return "redirect:result1"; 
	}
	
	@GetMapping("/test3") 
	public String test3_forward(HttpSession session) {
		//	HttpSession 객체 생성하기
		//	session = request.getSession();
		
		//	Session 영역에 data 가져오기 
		session.setAttribute("data1", "스프링 툴");
		return "forward:result1"; 
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		
		TestBean1 bean1 = new TestBean1();
		
		bean1.setData1("자바웹");
		bean1.setData2("HTTP/CSS");
		
		//	객체를 session scope에 올리기
		session.setAttribute("bean1", bean1);
		
		return "test4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpSession session) {
		
		//	TestBean1 bean1 = (TestBean1) session.getAttribute("bean1");
				
		return "result4";
	}
	
	
	@GetMapping("/test5")
	public String test5(HttpSession session) {
		
		TestBean1 bean1 = new TestBean1();
		
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTTP/CSS/JSON");
		
		//	객체를 session scope에 올리기
		session.setAttribute("bean1", bean1);
		
		return "test5";
	}
	
	@GetMapping("/result5")
	public String result5(@SessionAttribute("bean1") TestBean1 bean1) {
		
		return "result5";
	}
	
	
	@GetMapping("/test6")
	public String test6(HttpSession session, TestBean1 bean1) {
		
		bean1.setData1("자바웹프로그래밍1");
		bean1.setData2("HTTP/CSS/JSON");
		
		//	객체를 session scope에 올리기
		session.setAttribute("bean1", bean1);
		
		return "test6";
	}
	
	@GetMapping("/result6")
	public String result6(@SessionAttribute("bean1") TestBean1 bean1) {
		
		return "result6";
	}
}
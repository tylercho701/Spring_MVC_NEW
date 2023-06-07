package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.BeanData;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(BeanData bean) {
		
		bean.setData1("Spring framework");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(BeanData bean) {
		
		bean.setData1("Spring framework");
		bean.setData2("Web Application");
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(BeanData bean) {
		
		bean.setData1("Spring framework");
		bean.setData2("Web Application");
		bean.setData3("1234567890");
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String test4(BeanData bean) {
		
		bean.setData1("Spring framework");
		bean.setData2("Web Application");
		bean.setData3("1234567890");
		bean.setData4("This is Spring Legacy practice page tough at The JoEun IT Academy.");
		
		return "test4";
	}
	
	@PostMapping("/result")
	public String result(BeanData bean, HttpServletRequest request) {
		
		bean.setData1(request.getParameter("data1"));
		
		request.setAttribute("data1", bean.getData1());
		
		return "result";
	}
}
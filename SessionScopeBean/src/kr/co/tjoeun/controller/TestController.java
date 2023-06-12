package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

@Controller
public class TestController {
	
	
	//	Bean을 type으로 주입 받음
	@Autowired
	TestBeanByType testBeanByType;
	
	//	Bean을 name으로 주입 받음
	@Resource(name="sessionBean2")
	TestBeanByName sessionBean2;
	
	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}
	@GetMapping("/result1")
	public String result1() {
		
		return "result1";
	}
}
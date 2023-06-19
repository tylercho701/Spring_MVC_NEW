package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1() {
		System.out.println("*** 여기는 test1() 메소드입니다. ***");
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		System.out.println("*** 여기는 test2() 메소드입니다. ***");
		return "test2";
	}
	
	@GetMapping("/sub1/test3")
	public String test3() {
		System.out.println("*** 여기는 test3() 메소드입니다. ***");
		return "sub1/test3";
	}
	
	@GetMapping("/sub1/test4")
	public String test4() {
		System.out.println("*** 여기는 test4() 메소드입니다. ***");
		return "sub1/test4";
	}
}

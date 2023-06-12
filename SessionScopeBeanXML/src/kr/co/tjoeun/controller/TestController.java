package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1() {
		
		return "test1";
	}
	@GetMapping("/result1")
	public String result1() {
		
		return "result1";
	}
}
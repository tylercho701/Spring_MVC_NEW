package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/test1")
	//	ㄴ@RequestMapping(value="test1", method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "test2";
	}
}
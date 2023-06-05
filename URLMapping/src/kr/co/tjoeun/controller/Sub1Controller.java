package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sub1Controller {
	
	@RequestMapping(value="sub2", method=RequestMethod.GET)
	public String test5() {
		return "sub1/test5";
	}
	
	@RequestMapping(value="sub2", method=RequestMethod.GET)
	public String test6() {
		return "sub1/test6";
	}
}
package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
		return null;
	}
	
	@RequestMapping(value="/tjoeun", method=RequestMethod.GET)
	public String tjoeun() {
		System.out.println("tjoeun");
		return null;
	}
	
}






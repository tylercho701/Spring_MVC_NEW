package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController1 {

	@GetMapping("/input_data")
	public String input_data(TestBean1 bean1) {
		
		return "input_data";
	}
	
	@PostMapping("/input_procedure")
	public String input_procedure(@Valid TestBean1 bean1, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "input_data";
		}
		
		return "input_success";
	}
}

package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	
	@GetMapping("test1")
	public String test1(HttpServletRequest request) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println("number1 = "+number1);
		System.out.println("number2 = "+number2);
		
		int i = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + i + "] : "+number);
			i += 1;
		}
		
		return "result";
	}
	
	
	
	@PostMapping("test2")
	public String test2(HttpServletRequest request) throws Exception{
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println("number1 = "+number1);
		System.out.println("number2 = "+number2);
		
		if(numbers != null) {
			int i = 0;
			for(String number : numbers) {
				System.out.println("numbers[" + i + "] : "+number);
				i += 1;
			}
		}
		
		return "result";
	}
	
	
	@PostMapping("test3")
	public String test3(WebRequest request) throws Exception{
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println("number1 = "+number1);
		System.out.println("number2 = "+number2);
		
		if(numbers != null) {
			int i = 0;
			for(String number : numbers) {
				System.out.println("numbers[" + i + "] : "+number);
				i += 1;
			}
		}
		
		return "result";
	}
	
	
	
	@GetMapping("test4/{num1}/{num2}/{num3}/{num4}")
	public String test4(@PathVariable String num1,
						@PathVariable String num2,
						@PathVariable String num3,
						@PathVariable String num4) {
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		System.out.println("num4 = " + num4);
		
		return "result";
	}
	
	
	@GetMapping("test5/{num1}/{num2}/{num3}/{num4}")
	public String test5(@PathVariable int num1,
						@PathVariable int num2,
						@PathVariable int num3,
						@PathVariable int num4) {
		int sum = num1 + num2 + num3 + num4;
		System.out.println("sum = " + sum);
		
		return "result";
	}
	
	
	
	@GetMapping("test6")
	public String test6(@RequestParam int num1,
						@RequestParam int num2,
						@RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
		
		int sum = num1 + num2 + nums[0] + nums[1];
		
		System.out.println("합계 : " + sum);
		return "result";
	}
	
	
	
	@GetMapping("test7")
	public String test7(@RequestParam(value="num1") int number1,
						@RequestParam(value="num2") int number2,
						@RequestParam(value="nums") int[] numbers) {
		
		System.out.println("num1 : " + number1);
		System.out.println("num2 : " + number2);
		System.out.println("nums[0] : " + numbers[0]);
		System.out.println("nums[1] : " + numbers[1]);
		
		int sum = number1 + number2 + numbers[0] + numbers[1];
		
		System.out.println("합계 : " + sum);
		return "result";
	}
	
	
	
	@GetMapping("test8")
	public String test8(@RequestParam int num1,
						@RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
		
		int sum = num1 + nums[0] + nums[1];
		
		System.out.println("합계 : " + sum);
		return "result";
	}
	
	
	
	@GetMapping("test9")
	public String test9(@RequestParam int num1,
						@RequestParam int num2,
						@RequestParam int num3,
						@RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
		
		int sum = num1 + num2 + num3 + nums[0] + nums[1];
		
		System.out.println("합계 : " + sum);
		return "result";
	}
	
	
	@GetMapping("test10")
	public String test10(@RequestParam int num1,
						 @RequestParam int num2,
						 // @RequestParam(required=false) int num3,
						 @RequestParam(required=false) String num4,
						 @RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		// System.out.println("num3 : " + num3);
		System.out.println("num4 : " + num4);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
		
		// int sum = num1 + num2 + num3 + nums[0] + nums[1];
		
		// System.out.println("합계 : " + sum);
		return "result";
	}
	
	
	@GetMapping("test11")
	public String test11(@RequestParam int num1,
						 @RequestParam int num2,
						 @RequestParam(defaultValue="0") int num3,
						 @RequestParam int[] nums) {
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[1] : " + nums[1]);
		
		// int sum = num1 + num2 + num3 + nums[0] + nums[1];
		
		// System.out.println("합계 : " + sum);
		return "result";
	}
	
}
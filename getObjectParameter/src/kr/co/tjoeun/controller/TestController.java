package kr.co.tjoeun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.beans.BeansData;

@Controller
public class TestController {
	
	@GetMapping("test1")
	public String test1Get(@RequestParam Map<String, String> map) {
		String strNum1 = map.get("num1");
		String strNum2 = map.get("num2");
		
		String numMap = map.get("nums");
		
		System.out.printf("num1 : %s\n", strNum1);
		System.out.printf("num2 : %s\n", strNum2);
		System.out.printf("nums : %s\n", numMap);
		
		return "result";
	}
	
	
	@GetMapping("test2")
	public String test2Get(@RequestParam Map<String, String> map, @RequestParam List<String> nums) {
		String strNum1 = map.get("num1");					//	map으로 모두 들어오기 때문에 request의 변수명과 param의 변수명을 일치시킬 수 없음
		String strNum2 = map.get("num2");
		
		String numMap = map.get("nums");
		
		System.out.printf("num1 : %s\n", strNum1);
		System.out.printf("num2 : %s\n", strNum2);
		System.out.printf("num : %s\n", numMap);
		
		System.out.println("----------------------");
		System.out.println("같은 이름으로 전달된 2개의 data");
		System.out.println("----------------------");
		
		for(String numList : nums){							//	list로 받을 때는 request로 전달되는 변수명과 받는 param list의 이름이 같아야 하고,
			System.out.printf("nums : %s\n", numList);		//	list에 담을 때도 request로 전달되는 변수명과 같아야 헷갈리지 않음
		}
		
		return "result";
	}
	
	
	@GetMapping("test3")
	public String test3Get(@RequestParam Map<String, String> map, @RequestParam List<String> nums) {
		String strNum1 = map.get("num1");					//	map으로 모두 들어오기 때문에 request의 변수명과 param의 변수명을 일치시킬 수 없음
		String strNum2 = map.get("num2");		
		String strNumMap = map.get("nums");
		
		int intNum1 = Integer.parseInt(strNum1);
		int intNum2 = Integer.parseInt(strNum2);
		int intNumMap = Integer.parseInt(strNumMap);
		
		System.out.printf("num1 : %d\n", intNum1);
		System.out.printf("num2 : %d\n", intNum2);
		System.out.printf("num : %d\n", intNumMap);
		
		System.out.println("----------------------");
		System.out.println("같은 이름으로 전달된 2개의 data");
		System.out.println("----------------------");
		
		for(String numList : nums){							//	list로 받을 때는 request로 전달되는 변수명과 받는 param list의 변수명이 같아야 하고,
			System.out.printf("nums : %s\n", numList);		//	list에 담을 때도 request로 전달되는 변수명과 같아야 헷갈리지 않음
		}
		
		return "result";
	}
	
	
	@GetMapping("test4")
	public String test4Get(	@ModelAttribute BeansData bean1,
							@ModelAttribute BeansData bean2,
							@ModelAttribute BeansData bean3) {
		System.out.println("---- Beans Data 1 ----");
		System.out.printf("bean1.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean1.num2 : %d\n", bean1.getNum2());
		
		int index = 0;
		for(int nums : bean1.getNums()) {
			System.out.printf("bean1.nums[%d] : %d\n", index, nums);
			index += 1;
		}
		
	//	--------------------------------------------------
		
		System.out.println("---- Beans Data 2 ----");
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		
		index = 0;
		for(int nums : bean2.getNums()) {
			System.out.printf("bean2.nums[%d] : %d\n", index, nums);
			index += 1;
		}
		
//		--------------------------------------------------
		
		System.out.println("---- Beans Data 3 ----");
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		
		index = 0;
		for(int nums : bean3.getNums()) {
			System.out.printf("bean3.nums[%d] : %d\n", index, nums);
			index += 1;
		}
		
		return "result";
	}
	
	
	@GetMapping("test5")
	public String test5Get(	BeansData bean1,
							BeansData bean2,
							BeansData bean3) {
		System.out.println("---- Beans Data 1 ----");
		System.out.printf("bean1.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean1.num2 : %d\n", bean1.getNum2());
		
		int index = 0;
		for(int nums : bean1.getNums()) {
			System.out.printf("bean1.nums[%d] : %d\n", index, nums);
			index += 1;
		}
		
	//	--------------------------------------------------
		
		System.out.println("---- Beans Data 2 ----");
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		
		index = 0;
		for(int nums : bean2.getNums()) {
			System.out.printf("bean2.nums[%d] : %d\n", index, nums);
			index += 1;
		}
		
//		--------------------------------------------------
		
		System.out.println("---- Beans Data 3 ----");
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		
		index = 0;
		for(int nums : bean3.getNums()) {
			System.out.printf("bean3.nums[%d] : %d\n", index, nums);
			index += 1;
		}
		
		return "result";
	}
}
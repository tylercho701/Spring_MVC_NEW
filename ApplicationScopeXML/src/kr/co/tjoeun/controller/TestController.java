package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {

	//	ByType
	@Autowired
	TestBean1 applicationBean1;

	//	ByName
	@Resource(name="applicationBean2")
	TestBean2 applicationBean2;
	
	//	ByType
	@Autowired
	TestBean3 applicationBean3;
	
	//	ByName
	@Resource(name="applicationBean4")
	TestBean4 applicationBean4;
	
	@GetMapping("test1")
	public String test1() {
		
		applicationBean1.setData1("data1");
		applicationBean1.setData2("data2");
		applicationBean2.setData3("data3");
		applicationBean2.setData4("data4");
		
		return "test1";
	}
	@GetMapping("result1")
	public String result1(Model model) {
		
		System.out.printf("applicationBean1.data1 : %s\n", applicationBean1.getData1());
		System.out.printf("applicationBean1.data2 : %s\n", applicationBean1.getData2());
		System.out.printf("applicationBean2.data3 : %s\n", applicationBean2.getData3());
		System.out.printf("applicationBean2.data4 : %s\n", applicationBean2.getData4());
		
		//	model.addAttribute()로 data를 메모리에 올리면
		//	request scope에 저장됨	<-	result1.jsp에서 requestScope로 가져와야 함
		//	ByType 방식은 application Scope에 자동으로 저장되지 않아서 model로 request scope에 올림
		
		model.addAttribute("applicationBean1", applicationBean1);
		//	model.addAttribute("applicationBean2", applicationBean2);
		
		//	ByName 방식은 application Scope에 자동으로 저장되서 model로 request scope에 올리지 않아도 됨
		return "result1";
	}
	
	
	@GetMapping("test2")
	public String test2() {
		
		applicationBean3.setData5("data5");
		applicationBean3.setData6("data6");
		applicationBean4.setData7("data7");
		applicationBean4.setData8("data8");
		
		return "test2";
	}
	@GetMapping("result2")
	public String result2(Model model) {
		
		System.out.printf("applicationBean3.data5 : %s\n", applicationBean3.getData5());
		System.out.printf("applicationBean3.data6 : %s\n", applicationBean3.getData6());
		System.out.printf("applicationBean4.data7 : %s\n", applicationBean4.getData7());
		System.out.printf("applicationBean4.data8 : %s\n", applicationBean4.getData8());
		
		//	model.addAttribute()로 data를 메모리에 올리면
		//	request scope에 저장됨	<-	result1.jsp에서 requestScope로 가져와야 함
		//	ByType 방식은 application Scope에 자동으로 저장되지 않아서 model로 request scope에 올림
		
		model.addAttribute("applicationBean3", applicationBean3);
		//	model.addAttribute("applicationBean4", applicationBean4);
		
		//	ByName 방식은 application Scope에 자동으로 저장되서 model로 request scope에 올리지 않아도 됨
		return "result2";
	}
}
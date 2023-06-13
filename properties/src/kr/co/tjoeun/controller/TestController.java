package kr.co.tjoeun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//	-- 방법 1
//	@PropertySources({@PropertySource("/WEB-INF/properties/data1.properties"),
//					  @PropertySource("/WEB-INF/properties/data2.properties")})
//	-- 방법2
//	@PropertySource("/WEB-INF/properties/data1.properties")
//	@PropertySource("/WEB-INF/properties/data2.properties")
//	-- 방법3
@PropertySource(value= {"/WEB-INF/properties/data1.properties",
						"/WEB-INF/properties/data2.properties"})
public class TestController {
	
	@Value("${student1.number1}")		//	properties 파일에 지정한 변수명과 불러오는 값을 지정하는
	private int number1;				//	변수명이 동일 할 필요는 없음 (다만, 가독성을 위해 맞춰 쓰는 편)
	
	@Value("${student1.name1}")
	private String name1;
	
	@Value("${student2.number2}")
	private int number2;
	
	@Value("${student2.name2}")
	private String name2;
	
	@Value("${student3.number3}")
	private int number3;
	
	@Value("${student3.name3}")
	private String name3;
	
	@Value("${student4.number4}")
	private int number4;
	
	@Value("${student4.name4}")
	private String name4;

//	---------------------------------	
	
	@GetMapping("/test1")
	public String test1() {
		
		System.out.printf("student1.number1 : %d\n", number1);
		System.out.printf("student1.name1 : %s\n\n", name1);
		System.out.printf("student2.number2 : %d\n", number2);
		System.out.printf("student2.name2 : %s\n", name2);
		
		return "test1";
	}
}
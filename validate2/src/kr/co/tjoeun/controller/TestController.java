package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data(TestBean1 bean1) {
		
		return "input_data";
	}
	@PostMapping("input_result")
	public String inputProcedure(@Valid TestBean1 bean1, BindingResult result) {				//	@ModelAttribute에 별도 지정하지 않으면
																//	ClassName(=testBean1)로 RequestScope에 올라감
		System.out.printf("data1 : %s\n", bean1.getData1());
		System.out.printf("data2 : %s\n", bean1.getData2());

		System.out.printf("BindingResult : %s\n", result);
		
		if(result.hasErrors()) {
			//	유효성 위반 결과 모두 가져오기
			for(ObjectError error : result.getAllErrors()) {
				
				System.out.println("-------------------------------------------------");
				
				System.out.printf("에러메세지 : %s\n", error.getDefaultMessage());
				System.out.printf("에러코드 : %s\n", error.getCode());
				System.out.printf("Object Name: %s\n", error.getObjectName());
				
				String[] errorCodes = error.getCodes();
				for(String code : errorCodes) {
					System.out.println(code);
				}
				
				if(errorCodes[0].equals("size.testBean1.data1")) {
					System.out.println("data1은 2 ~ 10 글자만 입력할 수 있습니다.");
				} else if(errorCodes[0].equals("Max.testBean1.data2")) {
					System.out.println("data2는 Integer Type이며, 100을 초과할 수 없습니다.");
				}
				
			}
			return "input_data";
		}
		return "input_success";
	}
}

package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.BeanData;
import kr.co.tjoeun.beans.BeanKeyValue;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(BeanData bean, Model model) {
		
		bean.setData1("thejoeunacademy");
		bean.setData2("풀스택");
		bean.setData3("자바웹개발");
		bean.setData4("Linux");
		
		
		String[] checkList = {"C언어과정", "Spring과정"};
		bean.setData5(checkList);
		bean.setData6(checkList);
		bean.setData7(checkList);
		bean.setData8(checkList);

		
		//	data6
		String[] dataArray2 = {"데이터분석", "자바웹개발", "Spring과정", "풀스택"};
		model.addAttribute("dataArray2", dataArray2);
		
		
		//	data7
		ArrayList<String> dataList3 = new ArrayList<String>();
		dataList3.add("데이터분석");
		dataList3.add("자바웹개발");
		dataList3.add("풀스택");
		dataList3.add("C언어과정");
		model.addAttribute("dataList3", dataList3);
		
		
		//	data2
		String[] dataArray1 = {"데이터분석", "자바웹개발", "풀스택"};
		model.addAttribute("dataArray1", dataArray1);
		
		
		//	data3
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석");
		dataList1.add("자바웹개발");
		dataList1.add("풀스택");
		model.addAttribute("dataList1", dataList1);
		
		
		//	data4, data8
		BeanKeyValue key_bean1 = new BeanKeyValue();
		BeanKeyValue key_bean2 = new BeanKeyValue();
		BeanKeyValue key_bean3 = new BeanKeyValue();
		BeanKeyValue key_bean4 = new BeanKeyValue();
		key_bean1.setKey("과정1");
		key_bean1.setValue("자바웹개발");
		key_bean2.setKey("과정2");
		key_bean2.setValue("데이터분석");
		key_bean3.setKey("과정3");
		key_bean3.setValue("풀스택");
		key_bean4.setKey("과정4");
		key_bean4.setValue("Spring과정");
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<BeanKeyValue>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		dataList2.add(key_bean4);
		model.addAttribute("dataList2", dataList2);
		
		
		//	data8
		ArrayList<String> dataList4 = new ArrayList<String>();
		dataList3.add("데이터분석");
		dataList3.add("자바웹개발");
		dataList3.add("풀스택");
		dataList3.add("C언어과정");
		model.addAttribute("dataList4", dataList4);
		
		
		bean.setData9("자바웹개발");
		bean.setData10("자바웹개발");
		bean.setData11("자바웹개발");
		bean.setData12("자바웹개발");

		
		//	data10 배열
		String[] dataArray3 = {"데이터분석", "자바웹개발", "풀스택"};
		model.addAttribute("dataArray3", dataArray3);
		
		
		//	data11 리스트
		ArrayList<String> dataList5 = new ArrayList<String>();
		dataList5.add("데이터분석");
		dataList5.add("자바웹개발");
		dataList5.add("풀스택");
		dataList5.add("C언어과정");
		model.addAttribute("dataList5", dataList5);
		
		
		//	data12
		ArrayList<BeanKeyValue> dataList6 = new ArrayList<BeanKeyValue>();
		dataList6.add(key_bean1);
		dataList6.add(key_bean2);
		dataList6.add(key_bean3);
		dataList6.add(key_bean4);
		model.addAttribute("dataList6", dataList6);
		
		return "test1";
		
	}
}
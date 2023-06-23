package kr.co.tjoeun.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.UserService;
import kr.co.tjoeun.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//	server가 실행될 때 Session Scope에 생성한 UserBean 객체
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;

//	LOGIN/OUT	------------------------------------------------------------------------------------
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tmpLoginjoinUserBean") UserBean userbean,
						@RequestParam(value="fail", defaultValue="false")boolean fail,
						Model model) {
		
		model.addAttribute("fail", fail);
		
		return "user/login";
	}
	
	@PostMapping("/login_procedure")
	public String loginProcedure(@Valid
								 @ModelAttribute("tmpLoginjoinUserBean") UserBean tmpLoginjoinUserBean,
								 BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUserInfo(tmpLoginjoinUserBean);		
		if(loginUserBean.isUserLogin() == true) {
		
		return "user/login_success";
		} else {
			return "user/login_fail";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "user/logout";
	}

//	JOIN	---------------------------------------------------------------------------------------
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean")UserBean joinUserBean) {
		
		return "user/join";
	}
	
	@PostMapping("/join_procedure")
	public String joinProcedure(@Valid 
								@ModelAttribute("joinUserBean")UserBean joinUserBean,
								BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}
		
		userService.addUserInfo(joinUserBean);
		
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
		
		return "user/modify";
	}
	

	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator userValidator1 = new UserValidator();
		binder.addValidators(userValidator1);
	}
}
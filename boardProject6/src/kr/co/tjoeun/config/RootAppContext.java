package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.bean.UserBean;

//	상속 없음 : project 작업 시 사용할 Bean을 설정
@Configuration
public class RootAppContext {
	
	//	로그인하면 UserBean 객체를 SessionScope에 loginUserBean으로 저장함
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		
		return new UserBean();
	}
	
}
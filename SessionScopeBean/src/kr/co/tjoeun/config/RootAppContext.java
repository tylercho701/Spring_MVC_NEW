package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

//	상속 없음 : project 작업 시 사용할 Bean을 설정
@Configuration
public class RootAppContext {
	
	//	type으로 주입 받음 (=className)
	@Bean
	@SessionScope
	public TestBeanByType testBeanByType() {
		
		return new TestBeanByType();
	}
	
	//	name으로 주입 받음(@Bean("")으로 받는 이름 지정 가능)
	@Bean("sessionBean2")
	@SessionScope
	public TestBeanByName testBeanByName() {
		
		return new TestBeanByName();
	}
	
}
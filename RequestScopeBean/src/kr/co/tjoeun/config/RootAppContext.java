package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

//	상속 없음 : project 작업 시 사용할 Bean을 설정
@Configuration
public class RootAppContext {
	
	@Bean
	@RequestScope
	public TestBean1 testBean1() {
		
		return new TestBean1();
	}
	
	@Bean
	@RequestScope
	public TestBean2 testBean2() {
		
		return new TestBean2();
	}
}
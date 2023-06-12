package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

//	상속 없음 : project 작업 시 사용할 Bean을 설정
@Configuration
public class RootAppContext {
	
	@Bean
	@ApplicationScope
	public TestBean1 applicationBean1() {
		
		return new TestBean1();
	}
	
	@Bean("applicationBean2")
	@ApplicationScope
	public TestBean2 applicationBean2() {
		
		return new TestBean2();
	}
	
	/*@Bean
	@ApplicationScope
	public TestBean3 applicationBean3() {
		
		return new TestBean3();
	}
	
	@Bean("applicationBean2")
	@ApplicationScope
	public TestBean4 applicationBean4() {
		
		return new TestBean4();
	}*/
}
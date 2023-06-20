package kr.co.tjoeun.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.tjoeun.mapper.BoardMapper;

//	Spring MVC project에 관련된 설정을 하는 클래스: servlet-context.xml 역할을 하는 클래스
//	ServletAppContext의 객체는 SpringConfigClass 클래스의 onStartup 메소드에서 생성함
@Configuration
//	@Controller 어노테이션이 설정된 클래스를 controller로 등록하는 Annotation
@EnableWebMvc
//	 scan 할 bean들이 모여있는 package 지정하는 Annotation
@ComponentScan("kr.co.tjoeun.controller")
@ComponentScan("kr.co.tjoeun.dao")
@ComponentScan("kr.co.tjoeun.service")
@ComponentScan("kr.co.tjoeun.bean")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{
	
	@Value("${db.classname}")
	private String dbClassName;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String dbUserName;
	
	@Value("${db.password}")
	private String dbPassword;
	
	//	controller의 메소드에서 반환하는 문자열의 prefix와 suffix 경로 정보 설정하기
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	// 정적 파일 경로 지정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//	BasicDataSource : 데이터 베이스 접속 정보를 관리하는 Bean
	@Bean
	public BasicDataSource dataSource() {
		
		BasicDataSource source = new BasicDataSource();
		
		source.setDriverClassName(dbClassName);
		source.setUrl(dbUrl);
		source.setUsername(dbUserName);
		source.setPassword(dbPassword);
		
		return source;
	}
	
	//	Query문과 DB 접속 정보를 관리하는 Bean
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject(); 
		
		return factory;
	}
	
	//	Query문 실행을 위한 Bean(Mapper 관리)
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		
		return factoryBean;
	}
	
	
	
	
}
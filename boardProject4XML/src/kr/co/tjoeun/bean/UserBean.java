package kr.co.tjoeun.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserBean {
	
	private int user_idx;
	
	@Size(min=2, max=4)
	@Pattern(regexp="[가-힣]*")
	private String user_name;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String user_id;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String user_pw;
	
	@Size(min=4, max=20)
	@Pattern(regexp="[a-zA-Z0-9]*")
	private String user_pw2;
	
//	가입한 아이디 유무 여부를 저장하는 멤버 변수
	private boolean userIdExist;
	
	//	로그인 상태 여부를 저장하는 멤버 변수
	private boolean userLogin;
}
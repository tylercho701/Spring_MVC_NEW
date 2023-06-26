package kr.co.tjoeun.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	//	server가 실행될 때 Session Scope에 생성한 UserBean 객체
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDAO.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
		
		//	methodType=String 일 경우, return userDAO.checkUserIdExist(user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDAO.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean tmpLoginjoinUserBean) {
		
		UserBean tmpLoginjoinUserBean2 = userDAO.getLoginUserInfo(tmpLoginjoinUserBean);
		
		//	로그인 성공하여 로그인 한 id와 pw에 해당하는 user_name과 _idx를
		//	tmpLoginjoinUserBean2 객체에 저장하고 null이 아니게 됨
		//	user_idx와 _name은 Session Scope에 할당/저장되어
		//	사용자가 로그인 한 상태에서 계속 유지됨
		if(tmpLoginjoinUserBean2 != null) {
			loginUserBean.setUser_idx(tmpLoginjoinUserBean2.getUser_idx());
			loginUserBean.setUser_name(tmpLoginjoinUserBean2.getUser_name());
			loginUserBean.setUser_pw(tmpLoginjoinUserBean2.getUser_pw());
			loginUserBean.setUser_id(tmpLoginjoinUserBean2.getUser_id());
			
			loginUserBean.setUserLogin(true);
		}
	}
	
	public UserBean getModifyUserInfo(UserBean modifyUserBean) {
		
		//	DB로부터 가져온 id와 name을 저장하고 있는 userbean 객체
		UserBean tmpModifyUserInfo = userDAO.getModifyUserInfo(loginUserBean.getUser_idx());
		
		//	tmpModifyUserInfo 객체가 가지고 있는 id와 name 값을
		//	Spring 이 자동 생성해서 parameter로 전달해 준 modifyUserBean 객체의
		//	멤버변수 user_id와 user_name에 저장함
		
		modifyUserBean.setUser_id(tmpModifyUserInfo.getUser_id());
		modifyUserBean.setUser_name(tmpModifyUserInfo.getUser_name());
		modifyUserBean.setUser_pw(tmpModifyUserInfo.getUser_pw());
		
		//	현재 로그인 한 회원의 index 번호
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		return modifyUserBean;
	}
	
	public void modifyUserInfo(UserBean modifyUserBean) {
		//	Session Scope 에 있는 loginUserBean의 idx를 
		//	Controller에서 생성한 modifyUserBean 객체의 user_idx에 할당함
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		
		//	수정할 사용자의 user_idx 를 Service의 modifyUserInfo() 메소드로 넘겨줌
		userDAO.modifyUserInfo(modifyUserBean);
		
	}
}
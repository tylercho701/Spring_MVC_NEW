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
			
			loginUserBean.setUserLogin(true);
		}
		
	}
}
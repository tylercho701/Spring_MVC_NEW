package kr.co.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.UserBean;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		
		String user_name = sqlSessionTemplate.selectOne("checkUserIdExist");
		return user_name;
		
		//	return userMapper.checkUserIdExist(user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		sqlSessionTemplate.insert("addUserInfo");
	}
	
	public UserBean getLoginUserInfo(UserBean tmpLoginjoinUserBean) {
		UserBean userInfo = sqlSessionTemplate.selectOne("getLoginUserInfo",tmpLoginjoinUserBean);
		
		return userInfo;
	}
}
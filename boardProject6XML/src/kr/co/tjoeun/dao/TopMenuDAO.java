package kr.co.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.BoardInfoBean;

@Repository
public class TopMenuDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSesstionTemplate;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = sqlSesstionTemplate.selectList("topmenu.get_topmenu_list");
		return topMenuList;
	}
	
	
}
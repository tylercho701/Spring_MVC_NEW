package kr.co.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addContentInfo(ContentBean writeContentBean) {
		
		sqlSessionTemplate.insert("board.addContentInfo", writeContentBean);
	
	}
	
	public String getBoardInfoName(int board_info_idx) {
		
		return sqlSessionTemplate.selectOne("getBoardInfoName", board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx){
		
		return sqlSessionTemplate.selectList("getContentList", board_info_idx);
	}
	
	public ContentBean getContentInfo(int content_idx) {
		
		return sqlSessionTemplate.selectOne("getContentInfo", content_idx);
	}
}
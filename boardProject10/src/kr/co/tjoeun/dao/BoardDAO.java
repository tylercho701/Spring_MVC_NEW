package kr.co.tjoeun.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.mapper.BoardMapper;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void addContentInfo(ContentBean writeContentBean) {
		
		boardMapper.addContentInfo(writeContentBean);
		
	}
	
	public String getBoardInfoName(int board_info_idx) {
		
		return boardMapper.getBoardInfoName(board_info_idx);
	}
	
	public ArrayList<ContentBean> getContentList(int board_info_idx){
		
		return boardMapper.getContentList(board_info_idx);
	}
	
	public ContentBean getContentInfo(int content_idx) {
		
		return boardMapper.getContentInfo(content_idx);
	}
	
	public void modifyContentInfo(ContentBean modifyContentBean) {
		
		boardMapper.modifyContentInfo(modifyContentBean);
	}
	
	public void deleteContentInfo(int content_idx) {
		
		boardMapper.deleteContentInfo(content_idx);
	}
}
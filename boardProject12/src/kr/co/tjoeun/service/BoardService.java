package kr.co.tjoeun.service;

import java.io.File;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.PageBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.BoardDAO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	//	Session Scope에 있는 UserBean
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	//	파일 업로드 경로 설정
	@Value("${path.upload}")
	private String pathUpload;
	
	@Value("${page.listcnt}")
	private int pageListCnt;
	
	@Value("${page.paginationcnt}")
	private int pagiNationCnt;
	
	private String saveUploadFile(MultipartFile uploadFile) {
		String fileName = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
		
		try {
			
			uploadFile.transferTo(new File(pathUpload + "/" + fileName));
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return fileName;
	}
	
	
	public void addContentInfo(ContentBean writeContentBean) {
		/*
		System.out.println(writeContentBean.getContent_subject());
		System.out.println(writeContentBean.getContent_text());
		System.out.println(writeContentBean.getUpload_file().getSize());
		System.out.println(writeContentBean.getUpload_file());
		*/
		MultipartFile uploadFile =  writeContentBean.getUpload_file();
		
		if(uploadFile.getSize() > 0) {	
			// 파일 이름
			String fileName = saveUploadFile(uploadFile);
			//	System.out.println("fileName : " + fileName);
			writeContentBean.setContent_file(fileName);
		}
		
		// 현재 로그인 상태인 사람이 작성자가 됨
		// 작성자 인덱스번호(content_writer_idx) 에
		// 현재 로그인 상태인 사람(UserBean("loginUserBean"))의 
		// user_idx 를 할당함	
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		
		// Service 에서 DAO(Repository) 에 있는 addContentInfo() 호출하기
		boardDAO.addContentInfo(writeContentBean);
		
		
	}
	
	public String getBoardInfoName(int board_info_idx) {
		
		return boardDAO.getBoardInfoName(board_info_idx);
	}
	
	public ArrayList<ContentBean> getContentList(int board_info_idx, int page){
		
		int start = (page - 1) * pageListCnt;
		RowBounds rowBounds = new RowBounds(start, pageListCnt);
		
		return boardDAO.getContentList(board_info_idx, rowBounds);
	}
	
	public ContentBean getContentInfo(int content_idx) {
		
		return boardDAO.getContentInfo(content_idx);
	}
	
	public void modifyContentInfo(ContentBean modifyContentBean) {
		
		MultipartFile uploadFile =  modifyContentBean.getUpload_file();
		
		if(uploadFile.getSize() > 0) {	

			String fileName = saveUploadFile(uploadFile);
			modifyContentBean.setContent_file(fileName);
			
		}
		
		boardDAO.modifyContentInfo(modifyContentBean);
	}
	
	public void deleteContentInfo(int content_idx) {
		
		boardDAO.deleteContentInfo(content_idx);
	}
	
	public PageBean getContentCnt(int board_info_idx, int currentPage) {
		
		int contentCnt = boardDAO.getContentCnt(board_info_idx);
		
		PageBean pageBean = new PageBean(contentCnt, currentPage, pageListCnt, pagiNationCnt);
		
		return pageBean;
	}
	
} // Service Class
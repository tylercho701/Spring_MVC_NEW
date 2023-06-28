package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
	
	//	sequence값 가져오기
	//	조회 한 시퀀스 번호를 contentBean(writeContentBean)에 주입함
	@SelectKey(statement = "select CONTENT_SEQ.nextval from DUAL",
			   keyProperty = "content_idx", before = true, resultType = int.class)
	
	//	content_table에 insert하기
	@Insert("insert into content_table "
		  + "values (#{content_idx}, #{content_subject}, #{content_text}, "
		  							   + "#{content_file, jdbcType=VARCHAR}, "
		  							   + "#{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
	
	//	게시판 index로 게시판 이름 조회
	@Select("select board_info_name "
		  + "from board_info_table "
		  + "where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);
	
	//	게시글 리스트로 조회
	@Select("select c.content_idx, c.content_subject, u.user_name as content_writer_name, "
						 + "to_char(c.content_date, 'YYYY-MM-DD') as content_date "
		  + "from content_table c "
		  + "inner join user_table u "
		  				+ "on c.content_writer_idx = u.user_idx "
		  + "where c.content_board_idx = #{board_info_idx} "
		  + "order by c.content_idx desc")
	ArrayList<ContentBean> getContentList(int board_info_idx);
	
	//	상세 페이지에 출력 할 데이터 조회
	//	작성자(이름), 작성날짜, 제목, 내용, 첨부이미지
	@Select("select u.user_name as content_writer_name, to_char(c.content_date, 'YYYY-MM-DD') as content_date, c.content_subject, c.content_text, c.content_file, c.content_writer_idx from content_table c inner join user_table u on u.user_idx = c.content_writer_idx where content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);
	
	@Update("update content_table set content_subject = #{content_subject}, content_text = #{content_text}, content_file = #{content_file, jdbcType=VARCHAR} where content_idx = #{content_idx}")
	void modifyContentInfo(ContentBean modifyContentBean);
	
	@Delete("delete from content_table where content_idx = #{content_idx}")
	void deleteContentInfo(int content_idx);
}
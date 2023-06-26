package kr.co.tjoeun.mapper;

import org.apache.ibatis.annotations.Insert;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
	
	//	content_table에 insert하기
	@Insert("insert into content_table values (content_seq.nextval, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)")
	void addContentInfo(ContentBean writeContentBean);
	
	
}
package kr.co.tjoeun.bean;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ContentBean {

	private int content_idx;

	@NotBlank
	private String content_subject;
	
	@NotBlank
	private String content_text;
	
	private MultipartFile upload_file;		//	multipartFile 로 첨부 파일 받기
	private String content_file;
	private int content_writer_idx;
	private int content_board_idx;
	private String content_date;

}
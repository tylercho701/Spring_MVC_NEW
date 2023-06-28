package kr.co.tjoeun.bean;

import lombok.Data;

@Data
public class PageBean {
	//	최소 페이지 번호
	private int min;
	
	//	최대 페이지 번호
	private int max;
	
	//	이전 버튼의 페이지 번호
	private int prevPage;
	
	//	다음 버튼의 페이지 번호
	private int nextPage;
	
	//	전체 페이지 개수
	private int pageCnt;
	
	//	현재 페이지 번호
	private int currentPage;
	
	//	생성자 함수
	//	parameter > 전체 글 개수, 현재 글 번호, 페이지당 글 개수, 페이지 버튼 개수
	//				contentCnt	  currentPage	contentPageCnt	  pageNationCnt
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int pagiNationCnt) {
		//			from Database		parameter		
		//	현재 페이지 번호
		this.currentPage = currentPage;
		
		//	전체 페이지 개수 = 전체 글 개수 / 페이지 당 글 개수
		//	125 / 10 == 12 나머지 5
		//	125 % 10 == 5 > 0
		this.pageCnt = contentCnt / contentPageCnt;
		if(contentCnt % contentPageCnt > 0) {
			pageCnt += 1;
		}
		
		/*
					 min  max
			0 ~ 9  :  1,  10
		   10 ~ 19 : 11,  20
		   20 ~ 29 : 21,  30
		 */
		this.min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		this.max = this.min + pagiNationCnt - 1;
		
		if(this.max > pageCnt) {
			this.max = pageCnt;
		}
		
		this.prevPage = this.min - 1;
		this.nextPage = this.max + 1;
		
		if(this.nextPage > this.pageCnt) {
			this.nextPage = this.pageCnt;
		}
	}
}
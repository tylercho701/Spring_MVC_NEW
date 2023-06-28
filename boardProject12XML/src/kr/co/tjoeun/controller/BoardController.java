package kr.co.tjoeun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.PageBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.BoardService;

@Controller
///board 폴더 경로를 default 설정
@RequestMapping("/board")	
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;

	@GetMapping("/main")
	public String boardMain(@RequestParam("board_info_idx") int board_info_idx,
							@RequestParam(value="page", defaultValue="1") int page,
							Model model) {
		//	browser의 url에서 전달되는 'board_info_idx'를 받기 위해서
		//	주입 객체를 설정할 때 @RequestParam("board_info_idx")을 함께 설정해 줘야 함
		//	페이지가 넘어갈 때 마다 설정해서 공유해 줘야 함
		
		model.addAttribute("board_info_idx", board_info_idx);
		
		String board_info_name = boardService.getBoardInfoName(board_info_idx);
		model.addAttribute("board_info_name", board_info_name);
		
		List<ContentBean> contentList = boardService.getContentList(board_info_idx, page);
		model.addAttribute("contentList", contentList);
		
		model.addAttribute("loginUserBean", loginUserBean);
		
		PageBean pageBean = boardService.getContentCnt(board_info_idx, page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("page", page);
		
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead(@RequestParam("board_info_idx") int board_info_idx,
							@RequestParam("content_idx") int content_idx,
							@RequestParam("page") int page,
							Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		model.addAttribute("page", page);
		
		ContentBean contentInfo = boardService.getContentInfo(content_idx);
		model.addAttribute("contentInfo", contentInfo);
		
		return "board/read";
	}
	
	@GetMapping("/write")
	public String boardWrite(@ModelAttribute("writeContentBean") ContentBean writeContentBean,
							 @RequestParam("board_info_idx") int board_info_idx) {
		
		writeContentBean.setContent_board_idx(board_info_idx);
		
		return "board/write";
	}
	
	@PostMapping("/write_procedure")
	public String boardWriteProcedure(@Valid
									  @ModelAttribute("writeContentBean") ContentBean writeContentBean,
									  BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/write";
		}
		
		boardService.addContentInfo(writeContentBean);
		
		return "board/write_success";
	}
	
	@GetMapping("/not_writer")
	public String notWriter() {
		
		return "board/not_writer";
	}
	
	@GetMapping("/modify")
	public String boardModify(@RequestParam("board_info_idx") int board_info_idx,
							  @RequestParam("content_idx") int content_idx,
							  @RequestParam("page") int page,
							  @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
							  Model model) {
		
		model.addAttribute("page", page);
		
		ContentBean tmpContentBean = boardService.getContentInfo(content_idx);
		modifyContentBean.setContent_writer_name(tmpContentBean.getContent_writer_name());
		modifyContentBean.setContent_date(tmpContentBean.getContent_date());
		modifyContentBean.setContent_subject(tmpContentBean.getContent_subject());
		modifyContentBean.setContent_text(tmpContentBean.getContent_text());
		modifyContentBean.setContent_file(tmpContentBean.getContent_file());
		modifyContentBean.setContent_writer_idx(tmpContentBean.getContent_writer_idx());
		modifyContentBean.setContent_board_idx(board_info_idx);
		modifyContentBean.setContent_idx(content_idx);
		
		return "board/modify";
	}
	
	@PostMapping("/modify_procedure")
	public String boardModifyProcedure(@Valid
									   @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
									   @RequestParam("page") int page,
									   BindingResult result,
									   Model model) {
		
		model.addAttribute("page", page);
		
		if(result.hasErrors()) {
			return "board/modify";
		}
		
		boardService.modifyContentInfo(modifyContentBean);
		
		return "board/modify_success";
	}
	
	@GetMapping("/delete")
	public String boardDelete(@RequestParam("board_info_idx") int board_info_idx,
							  @RequestParam("content_idx") int content_idx,
							  Model model) {
		
		boardService.deleteContentInfo(content_idx);
		model.addAttribute("board_info_idx", board_info_idx);
		
		return "board/delete";
	}
}
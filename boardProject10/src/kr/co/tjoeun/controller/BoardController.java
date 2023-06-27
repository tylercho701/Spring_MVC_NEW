package kr.co.tjoeun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.BoardService;

@Controller
///board 폴더 경로를 default 설정
@RequestMapping("/board")	
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/main")
	public String boardMain(@RequestParam("board_info_idx") int board_info_idx, 		//	browser의 url에서 전달되는 'board_info_idx'를 받기 위해서
							Model model) {												//	주입 객체를 설정할 때 @RequestParam("board_info_idx")을 함께 설정해 줘야 함
		
		
		model.addAttribute("board_info_idx", board_info_idx);							//	페이지가 넘어갈 때 마다 설정해서 공유해 줘야 함
		
		String board_info_name = boardService.getBoardInfoName(board_info_idx);
		model.addAttribute("board_info_name", board_info_name);
		
		List<ContentBean> contentList = boardService.getContentList(board_info_idx);
		model.addAttribute("contentList", contentList);
		
		model.addAttribute("loginUserBean", loginUserBean);
		
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead(@RequestParam("board_info_idx") int board_info_idx,
							@RequestParam("content_idx") int content_idx,
							Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
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
							  @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
							  Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		modifyContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("modifyContentBean", modifyContentBean);
		
		return "board/modify";
	}
	
	@PostMapping("/modify_procedure")
	public String boardModifyProcedure(@Valid
									   @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
									   BindingResult result) {
		
		if(result.hasErrors()) {
			return "board/modify";
		}
		
		boardService.modifyContentInfo(modifyContentBean);
		
		return "board/modify_success";
	}
	
	@GetMapping("/delete")
	public String boardDelete() {
		
		return "board/delete";
	}
}
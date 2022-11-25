package com.bitacademy.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.mysite.service.BoardService;
import com.bitacademy.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<BoardVo> list = boardService.findContents();
		
		model.addAttribute("list",list);
		return "board/list";
	}
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVo boardVo) {
		boardService.addContents(boardVo);
		return "board/write";
	}
	@RequestMapping(value="/delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no") Long no, @RequestParam(value="userNo", required=true, defaultValue="") Long userNo) {
		boardService.deleteContents(no, userNo);
		return "redirect:/board	";
	}
	@RequestMapping(value="/view/{no}", method=RequestMethod.GET)
	public String view(@PathVariable("no")Long no, Model model) {
		boardService.getfindContents(no, no);
		model.addAttribute("no",no);
		return"board/view";
		
	}
	@RequestMapping(value = "/modify/{no}")
	public String modify( @PathVariable("no") Long no, Model model) {
		BoardVo boardVo = boardService.getfindContents(no,no);
		model.addAttribute("boardVo", boardVo);
		return "board/modify";
	}

	
}

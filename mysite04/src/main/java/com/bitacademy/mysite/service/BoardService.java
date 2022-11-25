package com.bitacademy.mysite.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.BoardRepository;
import com.bitacademy.mysite.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public void addContents(BoardVo vo) {
		 boardRepository.insert(vo);
	}
	
	public List<BoardVo> findContents() {
		return boardRepository.findAll();
	}
	
	public BoardVo getfindContents(Long no, Long userNo) {
		return null;
	}
	
	public Map<String, Object> findContentsList(int currentPage){
		// view의 페이징을 처리하기 위한 데이터의 값 계산
		int beginPage = 0;
		int endPage = 0;
		
		// 리스트 가져오기
		
		
		return null;
	}
	
	public void updateContents(BoardVo vo) {
		boardRepository.update(vo);
	}
	
	public void deleteContents(Long no, Long userNo) {
		BoardVo vo = new BoardVo();
		vo.setNo(no);
		vo.setUserNo(userNo);
		boardRepository.delete(vo);
	}
}
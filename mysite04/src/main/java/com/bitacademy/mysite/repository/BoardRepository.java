	package com.bitacademy.mysite.repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.BoardVo;

@Repository

public class BoardRepository {
	@Autowired
	private SqlSession sqlSession;
	public BoardVo findByTitleandContents(Long no) {
			
		return sqlSession.selectOne("borad.findByTitleandContents",no);
		
	
		
	}
	public Boolean insert(BoardVo vo) {
		int count = sqlSession.insert("board.insert", vo);
		return count == 1;
	}
	public Boolean delete(BoardVo vo) {
		int count = sqlSession.delete("board.delete", vo);
		return count == 1;
	}
	
	public List<BoardVo> findAll() {
		return sqlSession.selectList("board.findAll");
	
		
	}
	public boolean update(BoardVo vo) {
		int count = sqlSession.update("board.update	", vo);
		return count == 1;
		
	}

	

}

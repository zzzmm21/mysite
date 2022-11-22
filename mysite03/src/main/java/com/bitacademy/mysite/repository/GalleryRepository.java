package com.bitacademy.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.GalleryVo;
@Repository
public class GalleryRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(GalleryVo vo) {
		int count = sqlSession.insert("gallery.insert", vo);
		return count == 1;
	}

	public boolean delete(GalleryVo vo) {
		int count = sqlSession.delete("gallery.delete", vo);
		return count == 1;
	}
	
}

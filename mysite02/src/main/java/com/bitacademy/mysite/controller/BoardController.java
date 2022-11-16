package com.bitacademy.mysite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitacademy.mysite.dao.BoardDao;
import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;





public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("a");
		if("writeform".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);
	
		} else if("delete".equals(action)) {
			
			HttpSession session = request.getSession();
			UserVo authUser = (UserVo)session.getAttribute("authUser");

			if (authUser == null) {
				response.sendRedirect(request.getContextPath());
				return;
			}
			
			Long no = Long.parseLong(request.getParameter("no"));
			Long userNo = authUser.getNo();
			
			BoardVo vo = new BoardVo();
			vo.setUserno(userNo);
			vo.setNo(no);
			
			new BoardDao().delete(vo);
			
			response.sendRedirect(request.getContextPath() + "/board");
		} else if("wirte".equals(action)) {

			String no = request.getParameter("no");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(title);
			boardVo.setContents(content);
			boardVo.setNo(null);
			new BoardDao().insert(boardVo);

			response.sendRedirect(request.getContextPath() + "/board");
		} else if("view".equals(action)) {
			Long no = Long.parseLong(request.getParameter("no"));

			new BoardDao().updateHit(no);
			BoardVo boardVo = new BoardDao().findByTitleandContents(no);
			request.setAttribute("boardVo", boardVo);

			request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
			;
					
		} else if("modify".equals(action)) {	
			request
			.getRequestDispatcher("/WEB-INF/views/board/modify.jsp")
			.forward(request, response);
			
			
			
		} else {
			List<BoardVo> list = new BoardDao().findAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

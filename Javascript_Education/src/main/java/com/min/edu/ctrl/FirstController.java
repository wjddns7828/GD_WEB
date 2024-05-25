package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.Board_DTO;
import com.min.edu.dto.UserInfo_DTO;

public class FirstController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		//service -> dao->mybatis
		
		//로그인정보
		UserInfo_DTO info = new UserInfo_DTO("스위스", id, "알프스산맥", "A");
		//게시판 글
		List<Board_DTO> lists = new ArrayList<Board_DTO>();
		lists.add(new Board_DTO("글작성1", "우영일", "2020-06-27"));
		lists.add(new Board_DTO("글작성2", "우영이", "2021-06-27"));
		lists.add(new Board_DTO("글작성3", "우영삼", "2022-06-27"));
		lists.add(new Board_DTO("글작성4", "우영사", "2023-06-27"));
		
		req.setAttribute("login", info);
		req.setAttribute("board", lists);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
		dispatcher.forward(req, resp);
	}
}

package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.BoardDAOImpl;
import com.min.edu.dao.IBoardDAO;
import com.min.edu.dto.BoardDTO;

public class DetailBoard extends HttpServlet {
	
	IBoardDAO dao = new BoardDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String seq = req.getParameter("seq");
		BoardDTO oneBoard = dao.getOneboard(seq);
		req.setAttribute("oneBoard", oneBoard);
		forward(req, resp, "./WEB-INF/views/detailBoard.jsp");
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

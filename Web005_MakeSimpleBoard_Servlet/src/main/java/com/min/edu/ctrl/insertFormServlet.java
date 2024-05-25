package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.BoardDAOImpl;
import com.min.edu.dao.IBoardDAO;

public class insertFormServlet extends HttpServlet {
	
	IBoardDAO dao = new BoardDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp,"./WEB-INF/views/insertForm.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		System.out.printf("요청받은 값 %s | %s | %s",title,writer,content);
		
		int n = dao.setInsertBoard(title,writer,content);
		if(n>0) {
			resp.sendRedirect("./ListBoard.Servlet");
		}else {
			resp.sendRedirect("./index.jsp");
		}
		
		
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

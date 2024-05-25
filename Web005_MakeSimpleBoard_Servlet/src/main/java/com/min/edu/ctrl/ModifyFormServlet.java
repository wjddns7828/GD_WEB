package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.BoardDAOImpl;
import com.min.edu.dao.IBoardDAO;

public class ModifyFormServlet extends HttpServlet {
	IBoardDAO dao = new BoardDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command= req.getParameter("command");
		String seq = req.getParameter("seq");
		if(command.equals("modify")) {
			req.setAttribute("seq", seq);
			forward(req, resp, "./WEB-INF/views/ModifyForm.jsp");
		}else if(command.equals("del")) {
			int n = dao.setDeleteBoard(seq);
			if(n>0) {
				resp.sendRedirect("./index.jsp");
			}else {	
				System.out.println("삐빅");
				resp.sendRedirect("./WEB-INF/views/error.jsp");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		String title = (String) req.getParameter("title");
		String content = (String) req.getParameter("content");
		String seq = (String) req.getParameter("seq");
		System.out.println(title+"content"+content+"seq"+seq);
		map.put("title", title);
		map.put("content",content);
		map.put("seq", seq);
		int n = dao.setUpdateBoard(map);
		if(n>0){
			resp.sendRedirect("./detailBoard.Servlet?seq="+seq);
		}else {
			resp.sendRedirect("./WEB-INF/views/error.jsp");
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

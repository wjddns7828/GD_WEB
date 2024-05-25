package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 9173344449137691064L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String initParam = getServletConfig().getInitParameter("webInit");
		System.out.println(initParam);
		String contextParam = getServletContext().getInitParameter("spring");
		System.out.println("프로젝트 전체에서 사용 할 수 있는 초기 값 : "+ contextParam);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/servlet2.jsp").forward(req, resp);
	}
}

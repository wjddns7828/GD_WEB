package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * TODO 007 assembly로 되어있는 위치 중 클래스의 영역에 파일을 위치 시켜서 server를 통해서 접근 
 */
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String nickname =  req.getParameter("nickname");
		String val = (String) req.getAttribute("val");
		System.out.println("name : "+name+"|| nickname : "+nickname +"val : "+ val);
		
		req.setAttribute("val", "서버에서 전송하는 값");
		req.getRequestDispatcher("/WEB-INF/serverVal.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("second destroy");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("second init");
	}
}

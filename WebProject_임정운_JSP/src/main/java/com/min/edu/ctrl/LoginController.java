package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.min.edu.dto.UserInfo_DTO;



public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		id=id.trim();
		pw=pw.trim();
		
		HttpSession session = req.getSession();
		
		if(id.equals("admin")&& pw.equals("admin")) {
			UserInfo_DTO loginInfo = new UserInfo_DTO(id, pw, "admin", "1234", "Admin");
			session.setAttribute("info", loginInfo);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/mainPage.jsp");
			dispatcher.forward(req,resp);
		}else if(id.equals("user") && pw.equals("1234")){
			UserInfo_DTO loginInfo = new UserInfo_DTO(id, pw, "user", "7777", "user");
			session.setAttribute("info", loginInfo);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/mainPage.jsp");
			dispatcher.forward(req,resp);
		}else{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/loginaction.jsp");
			dispatcher.forward(req, resp);
		}
	}
}

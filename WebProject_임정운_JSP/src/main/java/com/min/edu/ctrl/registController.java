package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.UserInfo_DTO;

public class registController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DB에 값 넣었다 치고
		UserInfo_DTO info = new UserInfo_DTO
				((String)req.getParameter("id"), (String)req.getParameter("password"),(String)req.getParameter("name"), (String)req.getParameter("phone"), "User");
		
		info.setId((String)req.getParameter("id"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/registAction.jsp");
		dispatcher.forward(req, resp);
	}
}

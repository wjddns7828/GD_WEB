package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDTO;

public class registServlet extends HttpServlet {
	
	private static final long serialVersionUID = -9168749206223363962L;
	IUserDao dao = new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, "./WEB-INF/views/registForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String address= request.getParameter("address");
		String phone= request.getParameter("phone");
		String email = request.getParameter("email");
		
		System.out.printf("%s | %s | %s | %s | %s | %s",id, pw, name, address, phone,email);
		UserDTO dto = new UserDTO(id,pw,name,address,phone,email);
		int n = dao.insertUser(dto);
		if(n==1){
			forward(request, response, "./index.jsp");
		}else{
//			response.sendRedirect("./registForm.jsp");
			forward(request, response, "./WEB-INF/views/registForm.jsp");
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDTO;

public class updateUserServlet extends HttpServlet {
	private IUserDao dao;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new UserDaoImpl();
		HttpSession session = request.getSession();
		String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
		UserDTO dto = dao.getUserInfo(seq);
		request.setAttribute("dto", dto);
		forward(request,response,"./WEB-INF/views/updateForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		System.out.printf("%s %s %s %s \n" ,seq, address,phone,email);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("seq", seq);
		map.put("address", address);
		map.put("phone", phone);
		map.put("email", email);
		int n = dao.updateUserInfo(map);
		if(n>0){
			response.sendRedirect("./userInfo.Servlet");
		}else{
			response.sendRedirect("./WEB-INF/views/error.jsp");
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

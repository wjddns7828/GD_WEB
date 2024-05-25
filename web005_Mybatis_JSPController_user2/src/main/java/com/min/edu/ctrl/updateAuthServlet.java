package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDTO;

public class updateAuthServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4541337740252344552L;
	private Logger logger = Logger.getLogger(updateAuthServlet.class);
	IUserDao dao = new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		System.out.println("전달받은 파라미터 : " + seq);
		UserDTO dto = dao.getUserInfo(seq);
		request.setAttribute("dto",dto);
		forward(request,response,"./WEB-INF/views/updateAuthForm.jsp");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}

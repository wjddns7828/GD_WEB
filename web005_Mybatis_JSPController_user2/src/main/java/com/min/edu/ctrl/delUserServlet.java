package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDTO;

public class delUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9164498031611538538L;
	IUserDao dao = new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
		int n = dao.delUser(seq);
		if(n>0){
			forward(request,response,"./loginlogout.servlet");
		}else{
			forward(request,response,"./WEB-INF/views/error.jsp");

		}
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}

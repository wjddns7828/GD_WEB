package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;

public class IdChkServlet extends HttpServlet {
	IUserDao dao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean isc = false;

		if (dao.dupulicateId(id) == 1) {
			isc = true;
		}
		forward(request, response, "./WEB-INF/views/idChk.jsp?isc=" + isc);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

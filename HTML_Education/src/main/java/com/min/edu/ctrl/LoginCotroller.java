package com.min.edu.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("doGet호출");
		String reqName = request.getParameter("name");
		System.out.println(reqName);
		response.getWriter().print("<h1>나의 이름은?"+reqName+"</h1>");;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("doPost호출");
		String user = request.getParameter("user");
		String pw = request.getParameter("pw");
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>newpage</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append(user);
		sb.append(pw);
		sb.append("</body>");
		sb.append("</html>");
		response.getWriter().print(sb.toString());
	}
}

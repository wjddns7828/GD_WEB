package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserVo;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4478070591477592798L;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청된 조수의 값 => parameter 값을 name으로 호출하면 값을 확인 할 수 있고, 무조건 문자열(String)
		String loc = req.getParameter("loc");
		logger.info("주소에 의해서 전달받은 값 : "+ loc);
		//WEB-INF의 하위에 있는 파일에 요청, 요청의 위치는 JAVA의 값이면 모두 Forward로 호출해야함
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8");
		
		String loc = req.getParameter("loc"); //1.JSP -> 2.JSP -> 3.JSP
		logger.info("doPost 주소에 의해서 전달받은 값 : "+ loc);
		
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		logger.info("doPost 주소에 의해서 전달받은 값 : "+ id);
		logger.info("doPost 주소에 의해서 전달받은 값 : "+ pw);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", pw);
		
		IUserDao dao = new UserDaoImpl();
		UserVo loginVo = dao.loginSelect(map);
		logger.info("loginselect 실행 결과"+loginVo);
		
		//session처리 및 이동흐름
		if(loginVo==null) {
			resp.sendRedirect("./loginForm.jsp");
		}else {
			session.setAttribute("loginInfo", loginVo);
			resp.sendRedirect("./main.do");
		}
	}
}

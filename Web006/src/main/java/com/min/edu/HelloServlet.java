package com.min.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 002 web.xml에 servlet에 연결되는 class파일
 *
 */
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 9173344449137691064L;
	
	@Override
	public void init() throws ServletException {
		System.out.println(this.getClass().getName()+"초기화되었습니다.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getName()+"요청된 doGet처리 프로토콜");
		String var = req.getParameter("nowday");
		System.out.println(var);
		var = "금요일";
		//TODO 003 응답(response)
//		resp.setContentType("text/html; charset=UTF-8");
//		String html = "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<meta charset='UTF-8'>\r\n"
//				+ "<title>손으로 작성한 server의 화면</title>\r\n"
//				+ "</head>\r\n"
//				+ "<body>\r\n"
//				+ "	Hello World"+var+"\r\n"
//				+ "</body>\r\n"
//				+ "</html>";
//		resp.getWriter().println(html);
		//TODO 004 요청받은 값을 HTML 구성해주는 JSP로 값(객체)을 보낸 후
//					JSP에서 html을 구성 할 수 있도록 한다.
		req.setAttribute("returnvar", var+"은 즐거운 주말 또 다시 월요일");
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
	}
}

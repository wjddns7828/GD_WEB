package com.min.edu.ctrl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDTO;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = -5877269302886917396L;
	private Logger logger = Logger.getLogger(MainServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("MainServlet doGet");
		
		//Test index.jsp
//		HttpSession session = req.getSession();
//		session.setAttribute("loginInfo", new UserVo("두꺼비","진로","두꺼비@naver.com","U"));
//		
//		resp.sendRedirect("./index.jsp");
		
		//TODO 004 로그인이 된 후 첫번째 페이지인 모든 글 보기화면으로 이동
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		List<AnswerBoardDTO> lists =  dao.selectAllBoard();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date cDate =null;
		Date now = new Date();
		for (int i = 0; i < lists.size(); i++) {
			try {
				cDate = fmt.parse(lists.get(i).getRegdate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(cDate.equals(fmt.format(now))) {
				lists.get(i).setRegdate("오늘");
			}else {
				lists.get(i).setRegdate(fmt2.format(cDate));
			}
		}
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/boradMain.jsp").forward(req, resp);
	}
}

package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.comm.Jsflow;
import com.min.edu.dto.AnswerBoardDTO;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardReplyServlet extends HttpServlet {

	private static final long serialVersionUID = 1143902056622500545L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		logger.info("doGet");
		String seq = req.getParameter("seq");
		logger.info("doGet 에 입력받은 값 : "+seq);
		
		HttpSession session = req.getSession();
		if(session.getAttribute("loginInfo") == null) {
			String strHTML = Jsflow.jsForward("로그인 해주세요", "./boardLogin.do");
			resp.getWriter().print(strHTML);
		}else {
			IAnswerBoardDao dao = new AnswerBoardDaoImpl();
			AnswerBoardDTO dto =  dao.selectDetailBoard(seq);
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/WEB-INF/views/boardReply.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		logger.info("doPost");
		HttpSession session = req.getSession();
		UserVo loginVo = (UserVo)session.getAttribute("loginInfo");
		
		String pSeq = req.getParameter("seq");
		String id = loginVo.getId();
		String title= req.getParameter("title");
		String content = req.getParameter("content");
		String params = String.format("%s %s %s %s",pSeq,id,title,content);
		
		logger.info("받은 값 : "+params);
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setSeq(Integer.parseInt(pSeq));
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		boolean isc = dao.reply(dto);
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+dto.getSeq());
		}else {
			resp.sendRedirect("./logout.do");
		}
	}
}

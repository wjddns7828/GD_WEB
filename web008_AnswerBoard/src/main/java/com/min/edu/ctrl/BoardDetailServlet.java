package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDTO;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 5439537080009220204L;
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardDetailServlet doGet");
		String seq = req.getParameter("seq");
		logger.info("BoardDetailServlet doGet 요청 받은 값 : "+seq);
		
		IAnswerBoardDao dao = new AnswerBoardDaoImpl();
		AnswerBoardDTO dto = dao.selectDetailBoard(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("WEB-INF/views/boardDetail.jsp").forward(req, resp);
		
	}
}

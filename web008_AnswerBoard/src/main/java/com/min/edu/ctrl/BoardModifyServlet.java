package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoardDTO;
import com.min.edu.dto.UserVo;
import com.min.edu.model.AnswerBoardDaoImpl;
import com.min.edu.model.IAnswerBoardDao;

public class BoardModifyServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3965973428005406638L;
	private Logger logger = Logger.getLogger(BoardModifyServlet.class);
	IAnswerBoardDao dao = new AnswerBoardDaoImpl();

	//boardDetail 화면에서 수정폼 화면으로 이동하는 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("BoardModifyServlet doGet ");
		String seq = req.getParameter("seq");
		UserVo loginVo = (UserVo)req.getSession().getAttribute("loginInfo");
		logger.info("BoardModifyServlet doGet 요청 받은 값"+seq+loginVo);
		AnswerBoardDTO dto =  dao.selectDetailBoard(seq);
		if(loginVo.getId().equals(dto.getId())) {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("WEB-INF/views/boardModify.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("./logout.do");
		}
	}
	
	
	//요청받은 값을 DB에 적용하는 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		logger.info("BoardModifyServlet doPost ");
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		logger.info("BoardModifyServlet doPost 입력받은 seq :" +seq);
		logger.info("BoardModifyServlet doPost 입력받은 content :" +content);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("content", content);
		boolean isc = dao.modifyBoard(map);
		if(isc) {
			resp.sendRedirect("./detailBoard.do?seq="+seq);
		}else {
			resp.sendRedirect("./main.do");
		}
	}
}

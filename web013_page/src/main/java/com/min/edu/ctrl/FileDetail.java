package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDto2;
import com.min.edu.model.BoardImpl;
import com.min.edu.model.IBoard;

public class FileDetail extends HttpServlet {

	private static final long serialVersionUID = 6810429168988835194L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		logger.info(">>>>>>>>>>>>>>>>>>>>>> FileDetail doGet");
		String seq = req.getParameter("seq");
		IBoard dao = new BoardImpl();
		BoardDto2 bDto = dao.getOneBoard(seq);
		System.out.println(bDto);
		if(bDto != null) {
			req.setAttribute("bDto", bDto);
			req.getRequestDispatcher("/WEB-INF/views/fileOne.jsp").forward(req, resp);
		}
	}
}

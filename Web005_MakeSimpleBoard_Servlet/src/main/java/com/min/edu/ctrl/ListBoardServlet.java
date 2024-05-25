package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dao.BoardDAOImpl;
import com.min.edu.dao.IBoardDAO;
import com.min.edu.dto.BoardDTO;

public class ListBoardServlet extends HttpServlet {
	Logger logg = Logger.getLogger(this.getClass());
	IBoardDAO dao = new BoardDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardDTO> lists = dao.getAllBoard();
		req.setAttribute("board", lists);
		forward(req, resp,"./WEB-INF/views/ListBoard.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}

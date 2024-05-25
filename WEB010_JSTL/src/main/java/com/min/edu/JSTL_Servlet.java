package com.min.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.ScoreDTO;

public class JSTL_Servlet extends HttpServlet {

	private static final long serialVersionUID = -1803737871371890657L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
		
		for(int i = 0; i<10;i++) {
			ScoreDTO dto = new ScoreDTO("피카"+i,i+10,i+20,i+30,"츄");
			lists.add(dto);
		}
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/jstlPage.jsp").forward(req, resp);
	}
}

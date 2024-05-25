package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_DTO;
import com.min.edu.dto.Player_DTO4;
import com.min.edu.dto.Team_DTO;
import com.min.edu.dto.Team_DTO5;
import com.min.edu.model.IsocerDao;
import com.min.edu.model.SoccerDaoImpl;

public class MyBatisJoinController extends HttpServlet {

	private static final long serialVersionUID = -5363030570604979040L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//이동 흐름(redirect, forward)
//		req.setAttribute("requestValue", "값전송");
//		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		IsocerDao dao = new SoccerDaoImpl();
		
		//TODO 01-04 Controller에서 jsp로 값 전달
		List<All_Dto> lists = dao.joinCombine01();
			req.setAttribute("listsOne", lists);
		
		//TODO 02-03 JoinCombine02 Controller에서 jsp로 값 전달
		List<Team_DTO> lists02 = dao.joinCombine02();
			req.setAttribute("listsTwo", lists02);
		//TODO 03-03 JoinCombine03 Controller에서 jsp로 값 	
		List<Team_DTO> lists03 = dao.joinCombine03();
			req.setAttribute("listsThree", lists03);
		//TODO 04-04 JoinCombine03 Controller에서 jsp로 값 
		List<Player_DTO4> lists04 = dao.joinCombine04();
			req.setAttribute("listsFour", lists04);
			
		//TODO 05-04 JoinCombine05 Controller에서 jsp로 값 
		List<Team_DTO5> lists05 = dao.joinCombine05();
			req.setAttribute("listsFive", lists05);
			
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}

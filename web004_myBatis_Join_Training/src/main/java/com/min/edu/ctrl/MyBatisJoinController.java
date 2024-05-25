package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.All_DTO;
import com.min.edu.model.EmpDaoImpl;
import com.min.edu.model.IEmpDao;

public class MyBatisJoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IEmpDao dao = new EmpDaoImpl();
		
		List<All_DTO> lists = dao.selectAll();
			req.setAttribute("SELALL",lists);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
